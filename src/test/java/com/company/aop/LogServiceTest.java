package com.company.aop;

import com.company.aop.dto.SaveOrderDto;
import com.company.aop.dto.UpdateOrderDto;
import com.company.aop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testLog(){
        SaveOrderDto saveOrderDto = new SaveOrderDto();
        saveOrderDto.setOrderId(1L);
        orderService.saveOrder(saveOrderDto);

        UpdateOrderDto updateOrderDto = new UpdateOrderDto();
        updateOrderDto.setId(2L);
        orderService.updateOrder(updateOrderDto);
    }
}
