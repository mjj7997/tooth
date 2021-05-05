package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.clinic.common.utils.NumberUtil;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.GetPantientDto;
import com.clinic.provider.domain.dto.PatientMasterDto;
import com.clinic.provider.domain.entity.PatientMaster;
import com.clinic.provider.domain.entity.TagDict;
import com.clinic.provider.mapper.PatientMasterMapper;
import com.clinic.provider.service.PatientMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@Service
@Slf4j
public class PatientMasterServiceImpl extends ServiceImpl<PatientMasterMapper, PatientMaster> implements PatientMasterService {

    @Autowired
    PatientMasterMapper patientMasterMapper;

    private static final int LAST_DATE = 1;

    private static final int CLINIC_DATE = 2;

    private static final int VIP_CODE = 3;

    @Override
    public JSONObject getpatientId() {
        LocalDate localDate = LocalDate.now();
        String year = String.valueOf(localDate.getYear());
        String y = year.substring(2, 4);
        int monthValue = localDate.getMonthValue();
        String m = NumberUtil.geFourNumber(2, monthValue);
        int dayOfMonth = localDate.getDayOfMonth();
        String s = NumberUtil.geFourNumber(2, dayOfMonth);
        QueryWrapper<PatientMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clinic_date", localDate);
        List<PatientMaster> patientMasters = patientMasterMapper.selectList(queryWrapper);
        int max = 0;
        if (CollectionUtils.isEmpty(patientMasters)) {
            max = 1;
        } else {
            max = patientMasters.size() + 1;
        }
        String end = NumberUtil.geFourNumber(3, max);

        String result = y + m + s + end;
        log.info(result);
        return RenderResultUtil.success("查询成功", result);
    }

    @Override
    public JSONObject savePatientMaster(PatientMasterDto patientMasterDto) {
        //保存子类标签
        List<TagDict> tagDictList = patientMasterDto.getTagDictList();
        //人员列表
        PatientMaster master = patientMasterDto.getPatientMaster();
        PatientMaster patientMaster = new PatientMaster();
        BeanUtils.copyProperties(master, patientMaster);
        String tags = JSON.toJSONString(tagDictList);
        Integer id = patientMaster.getId();
        patientMaster.setClinicTagId(tags);
        patientMaster.setLastDate(LocalDate.now().toString());
        String phone = master.getPhone();
        String name = master.getName();
        String hospCode = master.getHospCode();
        QueryWrapper<PatientMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        queryWrapper.eq("name", name);
        queryWrapper.eq("hosp_code", hospCode);
        //查看病人是否已经建档
        List<PatientMaster> patientMasters = patientMasterMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(patientMasters)) {
            return RenderResultUtil.renderError("该患者已建档");
        }
        try {
            patientMasterMapper.insert(patientMaster);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("保存失败");
        }

        return RenderResultUtil.renderSuccess("保存成功");
    }

    @Override
    public JSONObject getPatientMasterByDto(GetPantientDto getPantientDto) {
        //输入内容
        String input = getPantientDto.getInput();
        //医院代码
        String hospCode = getPantientDto.getHospCode();
        if (StringUtils.isEmpty(hospCode)) {
            return RenderResultUtil.renderError("医院代码缺失");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("input", input);
        map.put("hospCode", hospCode);
        Integer selectStatus = getPantientDto.getSelectStatus();
        if (selectStatus == LAST_DATE) {
            map.put("lastDate", 1);
        } else if (selectStatus == CLINIC_DATE) {
            map.put("clinicDate", 2);
        } else if (selectStatus == VIP_CODE) {
            map.put("vipCode", 3);
        }
        List<PatientMaster> patientMasterByDto = patientMasterMapper.getPatientMasterByDto(map);
        return RenderResultUtil.success("查询成功", patientMasterByDto);
    }
}
