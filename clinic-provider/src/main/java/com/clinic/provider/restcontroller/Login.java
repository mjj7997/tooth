package com.clinic.provider.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.JsonResult;
import com.clinic.common.utils.MD5Utils;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.LoginDto;
import com.clinic.provider.domain.entity.StaffDict;
import com.clinic.provider.mapper.StaffDictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class Login {

    @Autowired
    private StaffDictMapper staffDictMapper;

    @PostMapping("doLogin")
    public JSONObject doLogin(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userId = loginDto.getUserId();
        String hospCode = loginDto.getHospCode();
        String password = loginDto.getPassword();
        //对字符串进行md5加密
        String md5Str = MD5Utils.getMD5Str(password);
        QueryWrapper<StaffDict> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<StaffDict> staffDicts = staffDictMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(staffDicts)) {
            return RenderResultUtil.error("未注册", false);
        }
        String staffPassword = staffDicts.get(0).getPassword();
        if (!staffPassword.equals(md5Str)) {
            return RenderResultUtil.error("密码不正确", false);
        }
        return RenderResultUtil.success("登录成功", true);
    }

}
