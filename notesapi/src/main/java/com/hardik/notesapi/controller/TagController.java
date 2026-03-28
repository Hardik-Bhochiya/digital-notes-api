package com.hardik.notesapi.controller;

import com.hardik.notesapi.entity.Tag;
import com.hardik.notesapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService service;

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return service.save(tag);
    }

    @GetMapping
    public List<Tag> getAll() {
        return service.getAll();
    }
}