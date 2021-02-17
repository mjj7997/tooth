package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.SaveRegistrationDto;
import com.clinic.provider.domain.entity.PatientMaster;
import com.clinic.provider.domain.entity.RegistrationMaster;
import com.clinic.provider.domain.entity.TitalDict;
import com.clinic.provider.domain.vo.GetRegistrationVo;
import com.clinic.provider.domain.vo.HeadlineVo;
import com.clinic.provider.mapper.PatientMasterMapper;
import com.clinic.provider.mapper.RegistrationMasterMapper;
import com.clinic.provider.service.RegistrationMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@Service
@Slf4j
public class RegistrationMasterServiceImpl extends ServiceImpl<RegistrationMasterMapper, RegistrationMaster> implements RegistrationMasterService {

    @Autowired
    private RegistrationMasterMapper registrationMasterMapper;

    @Autowired
    private PatientMasterMapper patientMasterMapper;



    @Override
    public JSONObject saveRegistrationMaster(SaveRegistrationDto saveRegistrationDto) {

        String phone = saveRegistrationDto.getPhone();
        String name = saveRegistrationDto.getName();
        String patientId = saveRegistrationDto.getPatientId();
        List<TitalDict> clinicTag = saveRegistrationDto.getClinicTag();
        QueryWrapper<PatientMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone).eq("name",name);
        List<PatientMaster> patientMasters = patientMasterMapper.selectList(queryWrapper);
        try {
            if (CollectionUtils.isEmpty(patientMasters)){
                PatientMaster patientMaster = new PatientMaster();
                BeanUtils.copyProperties(saveRegistrationDto,patientMaster);
                patientMaster.setLastDate(LocalDate.now().toString());
            }
            RegistrationMaster registrationMaster = new RegistrationMaster();
            BeanUtils.copyProperties(saveRegistrationDto,registrationMaster);
            QueryWrapper<RegistrationMaster> wrapper = new QueryWrapper<>();
            wrapper.eq("patient_id",patientId);
            List<RegistrationMaster> registrationMasters = registrationMasterMapper.selectList(wrapper);
            int visitId = 0;
            if (CollectionUtils.isEmpty(registrationMasters)){
                visitId = 1;
            }else {
                visitId = registrationMasters.size()+1;
            }
            registrationMaster.setVisitId(visitId);
            String tags = JSON.toJSONString(clinicTag);
            registrationMaster.setClinicTag(tags);
            registrationMasterMapper.insert(registrationMaster);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("保存失败");
        }

        return RenderResultUtil.renderSuccess("保存成功");
    }

    @Override
    public JSONObject getRegistrationMaster() {
        List<GetRegistrationVo> registrationMaster = registrationMasterMapper.getRegistrationMaster();
        return RenderResultUtil.success("查询成功",registrationMaster);
    }

    @Override
    public JSONObject getHeadline() {
        QueryWrapper<RegistrationMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("registration_date",LocalDate.now().toString());
        List<RegistrationMaster> registrationMasters = registrationMasterMapper.selectList(queryWrapper);
        int registration = 0;
        if (!CollectionUtils.isEmpty(registrationMasters)){
            registration = registrationMasters.size();
        }
        QueryWrapper<PatientMaster> wrapper = new QueryWrapper<>();
        wrapper.eq("clinic_date",LocalDate.now().toString());
        List<PatientMaster> patientMasters = patientMasterMapper.selectList(wrapper);
        int patient = 0;
        if (!CollectionUtils.isEmpty(patientMasters)){
            patient = registrationMasters.size();
        }
        HeadlineVo headlineVo = new HeadlineVo();
        headlineVo.setPatient(patient);
        headlineVo.setRegistration(registration);
        return RenderResultUtil.success("查询成功",headlineVo);
    }
}
