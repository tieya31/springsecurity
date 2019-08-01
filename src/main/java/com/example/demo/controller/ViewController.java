package com.example.demo.controller;


import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private final IUserService userService;

    @Autowired
    public ViewController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(Model model, String username) {
        //System.out.println("naruto");
        //model.addAttribute("msgs", userService.findByUsername(username));
        return "login";
    }

    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }

}