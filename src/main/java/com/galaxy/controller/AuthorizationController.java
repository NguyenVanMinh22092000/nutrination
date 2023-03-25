package com.galaxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorizationController {
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("/login");



        return modelAndView;
    }

}
