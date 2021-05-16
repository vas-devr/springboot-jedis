package com.devr.redistest.controller;

import com.devr.redistest.model.User;
import com.devr.redistest.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description about this classs......
 *
 * @author : vasudev
 * @created : 5/16/21
 * @since : v1.0.0-00
 */

@RestController
@RequestMapping("/rest/user")
public class UserResource {
    
    private UserRepository userRepository;
    
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.save(new User(id, name, 2000L));
        return userRepository.findById(id);
    }
    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.update(new User(id, name, 15000L));
        return userRepository.findById(id);
    }
    @GetMapping("/all")
    public Map<String, User> finadAll(){
        return userRepository.findAll();
    }
    @GetMapping("/delete/{id}")
    public Map<String,User> delete(@PathVariable("id") final String id){
        userRepository.delete(id);
        return userRepository.findAll();
    }
    
}
