package com.example.demologin.controller;

import com.example.demologin.entity.User;
import com.example.demologin.service.UserNotFoundException;
import com.example.demologin.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login/request")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session, RedirectAttributes ra){
        try {
            User userFind = service.login(email, password);
            session.setAttribute("curUser", userFind);
            ra.addFlashAttribute("message", "Login Successful");
            return "redirect:/api/users";
        } catch (UserNotFoundException e) {
            //ra.addFlashAttribute("message",e.getMessage());
            model.addAttribute("message", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        model.addAttribute("user", new User());
        return "login";
    }
}
