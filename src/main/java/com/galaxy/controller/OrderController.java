package com.galaxy.controller;

import com.galaxy.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;
    @GetMapping("adddishtoorder/{dishId}/{orderId}")
    public ModelAndView addDishToOrder(@PathVariable(name = "dishId") Long dishId,
                                       @PathVariable(name = "orderId") Long orderId){
        ModelAndView modelAndView = new ModelAndView("/order/list");
        orderService.addDishToOrder(dishId,orderId);
        modelAndView.addObject("order", orderService.findById(orderId));
        return modelAndView;
    }
    @GetMapping("deletedishinorder/{dishId}/{orderId}")
    public ModelAndView deleteDishInOrder(@PathVariable(name = "dishId") Long dishId,
                                       @PathVariable(name = "orderId") Long orderId){
        ModelAndView modelAndView = new ModelAndView("/order/list");
        orderService.deleteDishInOrder(dishId, orderId);
        modelAndView.addObject("order", orderService.findById(orderId));
        return modelAndView;
    }
//    @GetMapping("adddishtoorder/{dishId}/{orderId}")
//    public ResponseEntity<?> addDishToOrder(@PathVariable(name = "dishId") Long dishId,
//                                       @PathVariable(name = "orderId") Long orderId){
//        orderService.addDishToOrder(dishId, orderId);
//        return ResponseEntity.ok().body(orderService.findById(orderId));
//    }
}
