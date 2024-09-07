/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
package com.example;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author nada haninou
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired 
    private  UserRepository repo;
    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("nada.haninou@enim.ac.ma");
        user.setPassword("h");
        user.setFirstName("fatima");
        user.setLastName("lehfid");
        
        User saveUser = repo.save(user);
        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
        
    }
    /*@Test
    public void testListAll(){
        Iterable<User> users =repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User user:users){
            System.out.println(user);
        }
    }*/
    /*@Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optionalUser=repo.findById(userId);
        User user=optionalUser.get();
        user.setPassword("hoooooooooo");
        repo.save(user);
        User updaterUser=repo.findById(userId).get();
        Assertions.assertThat(updaterUser.getPassword()).isEqualTo("hello2000");
        
    }*/
    /*@Test
    public void testGet(){
        Integer userId=1;
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
}*/
    /*@Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }*/
}
