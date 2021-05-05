package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.MD5Utils;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.SelectStaffDto;
import com.clinic.provider.domain.dto.StaffDictDto;
import com.clinic.provider.domain.entity.StaffDict;
import com.clinic.provider.mapper.StaffDictMapper;
import com.clinic.provider.service.StaffDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-01-22
 */
@Service
@Slf4j
public class StaffDictServiceImpl extends ServiceImpl<StaffDictMapper, StaffDict> implements StaffDictService {

    @Autowired
    private StaffDictMapper staffDictMapper;

    @Override
    public JSONObject saveStaffDict(StaffDictDto staffDictDto) {
        try {
            List<StaffDict> staffDictList = staffDictDto.getStaffDictList();
            if (CollectionUtils.isEmpty(staffDictList)) {
                return RenderResultUtil.renderSuccess("插入成功");
            }
            String hospCode = staffDictList.get(0).getHospCode();
            QueryWrapper<StaffDict> wrapper = new QueryWrapper<>();
            wrapper.eq("hosp_code", hospCode);
            List<StaffDict> hospStaff = staffDictMapper.selectList(wrapper);
            List<String> collect = hospStaff.stream()
                    .map(entity -> entity.getUserId())
                    .collect(Collectors.toList());
            for (StaffDict staffDict : staffDictList) {
                String userId = staffDict.getUserId();
                if (collect.contains(userId)) {
                    return RenderResultUtil.renderError("工号重复");
                }
                String password = staffDict.getPassword();
                String md5Str = MD5Utils.getMD5Str(password);
                staffDict.setPassword(md5Str);
                staffDictMapper.insert(staffDict);
                Integer id = staffDict.getId();
                log.info("猜猜我是谁" + id.toString());
            }
            return RenderResultUtil.renderSuccess("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("插入失败");
        }
    }

    @Override
    public JSONObject getStaffDict(SelectStaffDto selectStaffDto) {
        String hospCode = selectStaffDto.getHospCode();
        Integer status = selectStaffDto.getStatus();

        String input = selectStaffDto.getInput();
        input = "%" + input + "%";
        List<StaffDict> staffDict = staffDictMapper.getStaffDict(status, hospCode, input);

        return RenderResultUtil.success("查询成功", staffDict);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public JSONObject delStaffDictById(Integer id) {
        QueryWrapper<StaffDict> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        staffDictMapper.deleteById(id);
        return RenderResultUtil.renderSuccess("删除成功");
    }

    @Override
    public JSONObject updateStaffDictById(StaffDictDto staffDictDto) {
        try {
            List<StaffDict> staffDictList = staffDictDto.getStaffDictList();
            if (CollectionUtils.isEmpty(staffDictList)) {
                return RenderResultUtil.renderSuccess("修改成功");
            }
            for (StaffDict staffDict : staffDictList) {
                Integer id = staffDict.getId();
                String password = staffDict.getPassword();
                String md5Str = MD5Utils.getMD5Str(password);
                staffDict.setPassword(md5Str);
                QueryWrapper<StaffDict> wrapper = new QueryWrapper<>();
                wrapper.eq("id", id);
                staffDictMapper.update(staffDict, wrapper);

            }
            return RenderResultUtil.renderSuccess("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("修改失败");
        }
    }

    @Override
    public JSONObject getStaffDictByUser(String userId) {
        QueryWrapper<StaffDict> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<StaffDict> staffDicts = staffDictMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(staffDicts)) {
            return RenderResultUtil.renderError("账户登录有误");
        }
        StaffDict staffDict = staffDicts.get(0);
        return RenderResultUtil.success("查询成功", staffDict);
    }


}
