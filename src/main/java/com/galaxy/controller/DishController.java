package com.galaxy.controller;

import com.galaxy.entity.Dish;
import com.galaxy.service.ICustomerService;
import com.galaxy.service.IDishService;
import com.galaxy.service.Impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DishController {
    private final IDishService dishService;
    private final ICustomerService customerService;

    @GetMapping("/dishes/{bmiId}/{mealId}")
    public ModelAndView getDishByBmi(@PathVariable(name = "bmiId")Long bmiId, @PathVariable(name = "mealId")Long mealId){
        ModelAndView modelAndView = new ModelAndView("/dish/list-bmi");
        modelAndView.addObject("dishes", dishService.getDishByBmi(bmiId, mealId));
        modelAndView.addObject("bmi", customerService.findById(2L).getBmi().getId());
        return modelAndView;
    }

}
