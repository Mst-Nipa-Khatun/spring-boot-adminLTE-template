package com.app.smartLoan.controller.view;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PageController {
    private static final Logger log = LoggerFactory.getLogger(PageController.class);


    @GetMapping("/dashboard")
    public String index() {
        return "dashboard";
    }

}
