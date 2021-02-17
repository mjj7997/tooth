package com.clinic.common.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {

    private static final Long serialVersionUID = 1L;

    private boolean success;
    private String status;
    private String msg;
    private T result;

}
