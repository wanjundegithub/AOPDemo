package com.company.aop.dto;

/**
 * 定义转换器接口，将非标准类型转化成标准类型
 * @param <PARAM>
 */
public interface LogConvert <PARAM>{
    LogDto convert(PARAM param);
}
