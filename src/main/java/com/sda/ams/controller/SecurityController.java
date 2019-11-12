package com.sda.ams.controller;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String noPage() {
        return "/client/list";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/unsecured")
    public String unsecured() {
        return "unsecured";
    }

    @GetMapping("/securedAdmin")
    public String securedAdmin() {
        return "client/create";
    }

    @GetMapping("/securedClient")
    public String securedClient() {
        return "securedClient";
    }

    @GetMapping("/logout")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/login";
    }

}
