package com.hi5code.example.controllers;

import com.hi5code.example.models.User;
import com.hi5code.example.utils.KeycloakTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SchoolController {

    @Autowired
    KeycloakTokenUtil keycloakTokenUtils;

    @RequestMapping("/")
    public String index() {
        return "school";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }

    @RequestMapping("/private/user/welcome")
    public String welcome(HttpServletRequest request, Model model) {
        User userDetails = keycloakTokenUtils.getUserDetails(request);
        model.addAttribute("user", userDetails);
        return "welcome";
    }

    @RequestMapping("/private/user/classrooms")
    public String classrooms(HttpServletRequest request, Model model) {
        User userDetails = keycloakTokenUtils.getUserDetails(request);
        model.addAttribute("user", userDetails);
        return "classrooms";
    }
}
