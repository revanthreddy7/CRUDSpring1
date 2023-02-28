package com.security.SecureApp.controller;

import com.security.SecureApp.Service.MyUserDetailsService;
import com.security.SecureApp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    User user = new User();

    @RequestMapping(value = "/home")
    public String Home() {
        return "mainhome";
    }

    @RequestMapping(value ="/register")
    public String Register() {
        return "register";

    }
    @RequestMapping(value = "/processRegister")
    @ResponseBody
    public ModelAndView processRegister(@RequestParam String username, @RequestParam String password, @RequestParam long id) {
        user.setUsername(username);
        user.setPassword(password);
        user.setId(id);
        myUserDetailsService.saveUserDetails(user);
//        System.out.println(user);
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value ="/login")
    public String Login() {
        return "login";
    }

    @PostMapping(value ="/processUpdateWallet")
    public String processUpdateWallet( long wallet_amt) {
        user.setWallet_amt(wallet_amt);
        myUserDetailsService.updateUserDetails(user);
        return "redirect:/home";

    }

    @RequestMapping(value ="/updateWallet")
    public String updateWallet() {
      return "updateWallet";

    }

//    @RequestMapping(value ="/processLogin")
//    public String processLogin(@RequestBody User user) {
//
//    }
}
