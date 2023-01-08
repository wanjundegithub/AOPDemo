package com.company.aop.dto;

/**
 * 保存订单转换器
 */
public class SaveOrderConvert implements LogConvert<SaveOrderDto>{
    @Override
    public LogDto convert(SaveOrderDto saveOrderDto) {
        LogDto logDto = new LogDto();
        logDto.setId(saveOrderDto.getOrderId());
        return logDto;
    }
}
