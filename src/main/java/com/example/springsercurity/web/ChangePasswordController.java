package com.example.springsercurity.web;

import com.example.springsercurity.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class ChangePasswordController {

    private final UserService service;

    public ChangePasswordController(UserService service) {
        this.service = service;
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword) {
        service.changeCurrentPassword(newPassword);
        return "redirect:/logout";
    }
}
