package com.ngc.Ex14_Lec109.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleLogin(@RequestParam(value = "error", required = false) boolean error, @RequestParam(value = "logout", required = false) boolean logout, Model model){
        String errorMsg = null;
        if (error){
            errorMsg = "Login failed! Username or Password is incorrect, please try again";
        } else if (logout) {
            errorMsg = "You have been successfully logged out!!";
        }
        model.addAttribute("errorMessge", errorMsg);
        return "login.html";
    }
}
