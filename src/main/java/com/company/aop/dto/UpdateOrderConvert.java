package com.company.aop.dto;

/**
 * 定义更新订单转换器
 */
public class UpdateOrderConvert implements LogConvert<UpdateOrderDto>{
    @Override
    public LogDto convert(UpdateOrderDto updateOrderDto) {
        LogDto logDto  =new LogDto();
        logDto.setId(updateOrderDto.getId());
        return logDto;
    }
}
