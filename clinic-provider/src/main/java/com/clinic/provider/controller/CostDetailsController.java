package com.clinic.provider.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/costDetails")
@Api(value = "单独操作计价费用api",tags = {"单独操作计价费用api"})
public class CostDetailsController {

}

