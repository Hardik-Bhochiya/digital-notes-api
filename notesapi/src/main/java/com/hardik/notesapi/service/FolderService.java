package com.hardik.notesapi.service;

import com.hardik.notesapi.entity.Folder;
import com.hardik.notesapi.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository repo;

    public Folder save(Folder folder) {
        return repo.save(folder);
    }

    public List<Folder> getAll() {
        return repo.findAll();
    }
}