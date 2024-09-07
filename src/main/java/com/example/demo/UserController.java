/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import java.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nada haninou
 */
@Controller
public class UserController {
    @Autowired
    private UserService Service;
    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers=Service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";    }
    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user,RedirectAttributes ra){
        Service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/users"; 
    }
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try {
            User user=Service.get(id);
            model.addAttribute("user", user);
             model.addAttribute("pageTitle", "Edit User (ID: "+id+")");
             return "user_form";
        } catch (UserNotFoundException e) {
           ra.addFlashAttribute("message", e.getMessage());
        return "redirect:/users";
        }
    }
    @GetMapping("/users/delete/{id}")
    public String deleteuser(@PathVariable("id")Integer id,RedirectAttributes ra){
        try {
            Service.delete(id);
            ra.addFlashAttribute("message", "The user Id "+id+" was deleted");
        } catch (UserNotFoundException e) {
           ra.addFlashAttribute("message", e.getMessage());
        
        }
        return "redirect:/users";
    }
    
}
