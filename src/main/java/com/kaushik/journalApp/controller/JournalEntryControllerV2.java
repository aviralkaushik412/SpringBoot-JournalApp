package com.kaushik.journalApp.controller;
import java.util.ArrayList;
import java.util.List;

import com.kaushik.journalApp.entity.JournalEntry;
import com.kaushik.journalApp.entity.User;
import com.kaushik.journalApp.service.JournalEntryService;
import com.kaushik.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
//    private Map<Long , JournalEntry> journalentries = new HashMap<>();
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;
    @GetMapping("{username}")
    public List<JournalEntry> getAllforUser(@PathVariable String username){
        User user = userService.findByUsername(username);
        if(user==null) return null;
        return user.getUserEntries();
    }

    @PostMapping("username")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry, String username){
        User user = userService.findByUsername(username);
        journalEntryService.saveEntry(myentry);
        return ResponseEntity.ok(myentry);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntry> getbyID(@PathVariable String myid ){
        JournalEntry Entry = journalEntryService.getByID(myid);
        if(Entry!=null) return ResponseEntity.ok(Entry);
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("id/{myid}")
    public JournalEntry deletebyID(@PathVariable Long myid){
        return null;
    }
    @PutMapping("id/{myid}")
    public JournalEntry updateByID(@PathVariable Long myid,@RequestBody JournalEntry myentry){
        return null;
    }
}
