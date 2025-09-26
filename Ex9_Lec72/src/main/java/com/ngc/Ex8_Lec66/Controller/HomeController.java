package com.ngc.Ex8_Lec66.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage(Model model){
        model.addAttribute("username", "Niranjan");
        return "home.html";
    }
}
