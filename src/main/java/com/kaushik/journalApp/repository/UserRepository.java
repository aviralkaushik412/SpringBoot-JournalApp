package com.kaushik.journalApp.repository;

import com.kaushik.journalApp.entity.JournalEntry;
import com.kaushik.journalApp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String user);
//    User findByUsern
}


// controller --> service --> repository