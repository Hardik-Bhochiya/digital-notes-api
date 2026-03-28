package com.hardik.notesapi.service;

import com.hardik.notesapi.entity.Tag;
import com.hardik.notesapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository repo;

    public Tag save(Tag tag) {
        return repo.save(tag);
    }

    public List<Tag> getAll() {
        return repo.findAll();
    }
}