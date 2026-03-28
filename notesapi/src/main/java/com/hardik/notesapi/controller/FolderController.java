package com.hardik.notesapi.controller;

import com.hardik.notesapi.entity.Folder;
import com.hardik.notesapi.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderService service;

    @PostMapping
    public Folder create(@RequestBody Folder folder) {
        return service.save(folder);
    }

    @GetMapping
    public List<Folder> getAll() {
        return service.getAll();
    }
}