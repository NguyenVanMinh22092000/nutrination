package com.galaxy.service;

import com.galaxy.dto.response.OrderDtoResponse;

public interface IOrderService extends IGeneralService<OrderDtoResponse>{
    void addDishToOrder(Long dishId, Long orderId);
    void deleteDishInOrder(Long dishId, Long orderId);
}
