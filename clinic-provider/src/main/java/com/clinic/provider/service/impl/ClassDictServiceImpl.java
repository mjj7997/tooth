package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.SaveClassDictDto;
import com.clinic.provider.domain.entity.ClassDict;
import com.clinic.provider.domain.entity.PriceDict;
import com.clinic.provider.domain.vo.GetClassDictVo;
import com.clinic.provider.domain.vo.GetPriceListVo;
import com.clinic.provider.domain.vo.PriceListVo;
import com.clinic.provider.mapper.ClassDictMapper;
import com.clinic.provider.mapper.PriceDictMapper;
import com.clinic.provider.service.ClassDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
@Service
@Slf4j
public class ClassDictServiceImpl extends ServiceImpl<ClassDictMapper, ClassDict> implements ClassDictService {

    @Autowired
    private ClassDictMapper classDictMapper;

    @Autowired
    private PriceDictMapper priceDictMapper;

    //诊疗类项目
    private static final String DIAGNOSIS = "1";

    //药品类项目
    private static final String MEDICINE = "2";


    @Override
    public JSONObject getClassDict(String hospCode) {
        QueryWrapper<ClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hosp_code", hospCode);
        List<ClassDict> classDicts = classDictMapper.selectList(queryWrapper);
        List<ClassDict> diagnosis = classDicts.stream()
                .filter(entity -> DIAGNOSIS.equals(entity.getPriceType()))
                .collect(Collectors.toList());
        List<ClassDict> medicine = classDicts.stream()
                .filter(entity -> MEDICINE.equals(entity.getPriceType()))
                .collect(Collectors.toList());
        GetClassDictVo getClassDictVo = new GetClassDictVo();
        getClassDictVo.setDiagnosis(diagnosis);
        getClassDictVo.setMedicines(medicine);
        return RenderResultUtil.success("查询成功", getClassDictVo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public JSONObject saveOrUpdateClassDict(SaveClassDictDto saveClassDictDto) {
        ClassDict classDict = new ClassDict();
        BeanUtils.copyProperties(saveClassDictDto, classDict);
        Integer id = saveClassDictDto.getId();
        if (id != null) {
            QueryWrapper<ClassDict> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            classDictMapper.update(classDict, queryWrapper);
            return RenderResultUtil.renderSuccess("修改成功");
        } else {
            classDictMapper.insert(classDict);
            return RenderResultUtil.renderSuccess("保存成功");
        }
    }

    @Override
    public JSONObject deleteClassDictById(Integer id) {
        QueryWrapper<ClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        try {
            classDictMapper.delete(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("删除失败");
        }
        return RenderResultUtil.renderSuccess("删除成功");
    }

    @Override
    public JSONObject getMenuList(String hospCode) {
        QueryWrapper<ClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hosp_code", hospCode);
        List<ClassDict> classDicts = classDictMapper.selectList(queryWrapper);
        PriceListVo priceListVo = new PriceListVo();
        List<ClassDict> diagnosis = classDicts.stream()
                .filter(entity -> DIAGNOSIS.equals(entity.getPriceType()))
                .collect(Collectors.toList());
        List<GetPriceListVo> diagnosisList = new ArrayList<>();
        List<GetPriceListVo> priceList1 = getPriceList(diagnosisList, diagnosis);

        List<ClassDict> medicine = classDicts.stream()
                .filter(entity -> MEDICINE.equals(entity.getPriceType()))
                .collect(Collectors.toList());
        List<GetPriceListVo> medicineList = new ArrayList<>();
        List<GetPriceListVo> priceList2 = getPriceList(medicineList, medicine);
        priceListVo.setDiagnosisVoList(priceList1);
        priceListVo.setDiagnosisVoList(priceList2);
        return RenderResultUtil.success("查询成功", priceListVo);
    }

    private List<GetPriceListVo> getPriceList(List<GetPriceListVo> list, List<ClassDict> classDictList) {

        for (ClassDict classDict : classDictList) {
            QueryWrapper<PriceDict> queryWrapper = new QueryWrapper<>();
            Integer id = classDict.getId();
            queryWrapper.eq("class_type", id);
            List<PriceDict> priceDicts = priceDictMapper.selectList(queryWrapper);
            GetPriceListVo getPriceListVo = new GetPriceListVo();
            getPriceListVo.setClassDict(classDict);
            getPriceListVo.setPriceDictList(priceDicts);
            list.add(getPriceListVo);
        }
        return list;
    }

}
