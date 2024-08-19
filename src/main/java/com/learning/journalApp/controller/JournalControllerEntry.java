package com.learning.journalApp.controller;

import com.learning.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalControllerEntry {

    private Map<Long, JournalEntry> entries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(entries.values());
    }

    @PostMapping
    public boolean setEntries(@RequestBody JournalEntry myEntry){
        entries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id")
    public JournalEntry getEntryById(@RequestParam long myId){
        return entries.get(myId);
    }

    @DeleteMapping("id")
    public JournalEntry deleteEntryById(@RequestParam long myId){
        return entries.remove(myId);
    }

    @PutMapping("id")
    public JournalEntry updateEntryById(@RequestParam long myId, @RequestBody JournalEntry newEntry){
        return entries.put(myId, newEntry);
    }
}
