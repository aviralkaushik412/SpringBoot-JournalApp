package com.kaushik.journalApp.controller;
import java.util.Map;
import java.util.List;

import com.kaushik.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<Long , JournalEntry> journalentries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalentries.values());
    }
    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myentry){
        journalentries.put(myentry.getId(),myentry);
        return true;
    }
    @GetMapping("/id/{myid}")
    public JournalEntry getbyID(@PathVariable Long myid ){
        return journalentries.get(myid);
    }
    @DeleteMapping("id/{myid}")
    public JournalEntry deletebyID(@PathVariable Long myid){
        return journalentries.remove(myid);
    }
    @PutMapping("id/{myid}")
    public JournalEntry updateByID(@PathVariable Long myid,@RequestBody JournalEntry myentry){
        return journalentries.put(myid,myentry);
    }
}
