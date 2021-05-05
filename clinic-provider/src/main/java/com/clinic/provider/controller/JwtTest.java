package com.clinic.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: majunjie
 * @Date: 2021年3月10日$ 23点39分$
 * @Description:
 */
@RequestMapping("api")
@RestController
public class JwtTest {

    @GetMapping("test")
    public String test() {
        return "hello world";
    }
}
