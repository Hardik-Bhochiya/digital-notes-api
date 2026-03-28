package com.hardik.notesapi.controller;

import com.hardik.notesapi.entity.Note;
import com.hardik.notesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    // CREATE NOTE
    @PostMapping
    public Note create(@RequestBody Note note) {
        return service.save(note);
    }

    // GET ALL NOTES
    @GetMapping
    public List<Note> getAll() {
        return service.getAll();
    }

    // 🔍 SEARCH
    @GetMapping("/search")
    public List<Note> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    // ⭐ IMPORTANT NOTES
    @GetMapping("/important")
    public List<Note> importantNotes() {
        return service.getImportantNotes();
    }

    // 👤 NOTES BY USER
    @GetMapping("/user/{id}")
    public List<Note> getByUser(@PathVariable Long id) {
        return service.getByUser(id);
    }
}