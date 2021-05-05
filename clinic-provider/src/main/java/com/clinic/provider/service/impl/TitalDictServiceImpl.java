package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.TitalDictDto;
import com.clinic.provider.domain.entity.TitalDict;
import com.clinic.provider.mapper.TitalDictMapper;
import com.clinic.provider.service.TitalDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-12
 */
@Service
@Slf4j
public class TitalDictServiceImpl extends ServiceImpl<TitalDictMapper, TitalDict> implements TitalDictService {

    @Autowired
    private TitalDictMapper titalDictMapper;

    @Override
    public JSONObject saveTitalDict(TitalDictDto titalDictDto) {
        TitalDict titalDict = new TitalDict();
        BeanUtils.copyProperties(titalDictDto, titalDict);
        Integer id = titalDictDto.getId();
        try {
            if (id != null){
                QueryWrapper<TitalDict> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id", id);
                titalDictMapper.update(titalDict, queryWrapper);
            }else {
                titalDictMapper.insert(titalDict);
            }

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("修改失败");
        }
        return RenderResultUtil.renderSuccess("编辑成功");
    }

    @Override
    public JSONObject deleteTitalDict(Integer id) {
        try {
            QueryWrapper<TitalDict> queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            titalDictMapper.delete(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("删除失败");
        }

        return RenderResultUtil.renderSuccess("删除成功");
    }

    @Override
    public JSONObject updateTitalDict(TitalDictDto titalDictDto) {
        TitalDict titalDict = new TitalDict();
        Integer id = titalDictDto.getId();
        BeanUtils.copyProperties(titalDictDto, titalDict);
        try {
            QueryWrapper<TitalDict> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            titalDictMapper.update(titalDict, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("修改失败");
        }
        return RenderResultUtil.renderSuccess("保存成功");
    }
}
