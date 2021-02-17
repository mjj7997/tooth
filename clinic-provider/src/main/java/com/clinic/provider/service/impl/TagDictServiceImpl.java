package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.TagListDto;
import com.clinic.provider.domain.entity.TagDict;
import com.clinic.provider.domain.entity.TitalDict;
import com.clinic.provider.mapper.TagDictMapper;
import com.clinic.provider.mapper.TitalDictMapper;
import com.clinic.provider.service.TagDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@Service
public class TagDictServiceImpl extends ServiceImpl<TagDictMapper, TagDict> implements TagDictService {

    @Autowired
    private TagDictMapper tagDictMapper;

    @Autowired
    private TitalDictMapper titalDictMapper;


    @Override
    public JSONObject getPatientTag() {
        QueryWrapper<TagDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_type",1);
        List<TagDict> tagDicts = tagDictMapper.selectList(queryWrapper);
        return RenderResultUtil.success("查询成功",tagDicts);
    }

    @Override
    public JSONObject getRegistrationTag(TagListDto tagListDto) {

        List<Integer> tagList = tagListDto.getTagList();
        if (tagList.size()>0){
            List<TitalDict> titalDict = titalDictMapper.getTitalDict(tagList);
            return RenderResultUtil.success("查询成功",titalDict);
        }else {
            QueryWrapper<TitalDict> queryWrapper = new QueryWrapper<>();
            List<TitalDict> titalDict = titalDictMapper.selectList(queryWrapper);
            return RenderResultUtil.success("查询成功",titalDict);
        }



    }
}
