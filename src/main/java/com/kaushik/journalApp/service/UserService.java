package com.kaushik.journalApp.service;

import com.kaushik.journalApp.entity.JournalEntry;
import com.kaushik.journalApp.entity.User;
import com.kaushik.journalApp.repository.JournalEntryRepository;
import com.kaushik.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User users){
        userRepository.save(users);
    }
    public List<User> getALL(){
        return userRepository.findAll();
    }
    public User getByID(String id){
        return userRepository.findById(id).orElse(null);
    }
    public User findByUsername(String user){
        return userRepository.findByUsername(user);
    }
    public List<JournalEntry> getJournalEntry(){
        return new ArrayList<>();
    }
}
