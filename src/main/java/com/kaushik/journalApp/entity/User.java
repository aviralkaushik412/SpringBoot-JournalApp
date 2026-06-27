package com.kaushik.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;

    @DBRef
    private List<JournalEntry> userEntries = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<JournalEntry> getUserEntries() {
        return userEntries;
    }

    public void setUserEntries(List<JournalEntry> userEntries) {
        this.userEntries = userEntries;
    }
}
