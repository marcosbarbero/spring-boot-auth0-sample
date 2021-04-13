package com.auth0.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping({"/", "/login"})
    public String login() {
        return "/login";
    }

    @GetMapping("/private/home")
    public String home() {
        return "/private/home";
    }

}
