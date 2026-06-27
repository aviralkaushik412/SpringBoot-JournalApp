package com.kaushik.journalApp.service;

import com.kaushik.journalApp.entity.JournalEntry;
import com.kaushik.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getALL(){
        return journalEntryRepository.findAll();
    }
    public JournalEntry getByID(String id){
        return journalEntryRepository.findById(id).orElse(null);
    }
}
