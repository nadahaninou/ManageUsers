/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author nada haninou
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    public Long countById(Integer id);
}
