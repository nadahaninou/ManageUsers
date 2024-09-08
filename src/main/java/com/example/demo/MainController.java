/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework;
import org.springframework;
/**
 *
 * @author nada haninou
 */
@Controller
public class MainController {
     @GetMapping("")
   public String showHomePge(){
       System.out.println("main controller");
       return "index";
   }
}
