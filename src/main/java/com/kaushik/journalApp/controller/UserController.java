package com.kaushik.journalApp.controller;
import java.util.ArrayList;
import java.util.List;

import com.kaushik.journalApp.entity.User;
import com.kaushik.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getALL();
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.saveEntry(user);
    }
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user , @PathVariable String username ){
        User UserInDb = userService.findByUsername(username);
        if(UserInDb!=null){
            UserInDb.setPassword(user.getPassword());
            UserInDb.setUsername(user.getUsername());
            userService.saveEntry(UserInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
