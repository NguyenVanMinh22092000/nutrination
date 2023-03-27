package com.galaxy.controller;

import com.galaxy.dto.request.DishDtoRequest;
import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.dto.response.DishDtoResponse;
import com.galaxy.entity.Customer;
import com.galaxy.entity.Dish;
import com.galaxy.service.ICustomerService;
import com.galaxy.service.IDishService;
import com.galaxy.service.Impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DishController {
    private final IDishService dishService;
    private final ICustomerService customerService;

    @GetMapping("/dishes/{customerId}/{mealId}")
    public ModelAndView getDishByBmi(@PathVariable(name = "customerId")Long customerId,
                                     @PathVariable(name = "mealId")Long mealId){
        ModelAndView modelAndView = new ModelAndView("/dish/list-bmi");
        Long bmiId = customerService.findById(customerId).getBmi().getId();
        modelAndView.addObject("dishes", dishService.getDishByBmi(bmiId, mealId));
        modelAndView.addObject("bmi", bmiId);
        modelAndView.addObject("customerId",customerId );
        return modelAndView;
    }
    @GetMapping("/dish/create")
    public  ModelAndView CreateDish(){
        ModelAndView modelAndView = new ModelAndView("/dish/create");
        modelAndView.addObject("dish", new DishDtoRequest());
        return modelAndView;
    }

    @PostMapping("/dish/create")
    public ModelAndView CreateDish(@ModelAttribute("dish") DishDtoResponse dishDtoResponse){
        dishService.save(dishDtoResponse);
        ModelAndView modelAndView = new ModelAndView("/dish/create");
        modelAndView.addObject("message", "Create Dish Successfully");
        return modelAndView;

    }
    @GetMapping("/dish/delete/{id}")
    public ModelAndView DeleteDish(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/dish/delete");
        modelAndView.addObject("dish",dishService.findById(id));
        return modelAndView;
    }
    @PostMapping("/dish/delete/{id}")
    public ModelAndView Delete(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/dish/list");
        modelAndView.addObject("message","Delete Dish Successfully ");
        dishService.remove(id);
        return modelAndView;
    }
    @GetMapping("/dish/list")
    public ModelAndView Dish(){
        ModelAndView modelAndView = new ModelAndView("/dish/list");
        modelAndView.addObject("dishes",dishService.findAll());
        return modelAndView;
    }


}
