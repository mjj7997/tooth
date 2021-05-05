package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.clinic.common.utils.Pinyin4jUtil;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.SavePriceDictDto;
import com.clinic.provider.domain.entity.PriceDict;
import com.clinic.provider.mapper.PriceDictMapper;
import com.clinic.provider.service.PriceDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

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
public class PriceDictServiceImpl extends ServiceImpl<PriceDictMapper, PriceDict> implements PriceDictService {


    @Autowired
    private PriceDictMapper priceDictMapper;

    @Override
    public JSONObject getPriceDictByClassId(String classId, String input, String hospCode) {

        List<PriceDict> priceDictByClassId = priceDictMapper.getPriceDictByClassId(classId, input, hospCode);
        return RenderResultUtil.success("查询成功", priceDictByClassId);
    }

    @Override
    public JSONObject saveOrUpdatePriceDict(SavePriceDictDto savePriceDictDto) {
        PriceDict priceDict = new PriceDict();
        Integer id = savePriceDictDto.getId();
        BeanUtils.copyProperties(savePriceDictDto, priceDict);
        String itemName = savePriceDictDto.getItemName();
        if (!StringUtils.isEmpty(itemName)) {
            String inputCode = Pinyin4jUtil.converterToFirstSpell(itemName);
            priceDict.setInputCode(inputCode);
        }
        try {
            if (id != null) {
                QueryWrapper<PriceDict> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id", id);
                priceDictMapper.update(priceDict, queryWrapper);
                return RenderResultUtil.renderSuccess("修改成功");
            } else {
                priceDictMapper.insert(priceDict);
                return RenderResultUtil.renderSuccess("新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("编辑失败");
        }

    }

    @Override
    public JSONObject deletePriceDictById(String id) {
        QueryWrapper<PriceDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        try {
            priceDictMapper.delete(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("删除失败");
        }
        return RenderResultUtil.renderSuccess("删除成功");
    }
}
