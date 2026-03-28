package com.hardik.notesapi.service;

import com.hardik.notesapi.entity.Note;
import com.hardik.notesapi.entity.Tag;
import com.hardik.notesapi.repository.NoteRepository;
import com.hardik.notesapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repo;

    @Autowired
    private TagRepository tagRepo;

    // CREATE NOTE
    public Note save(Note note) {

        // Handle tags (avoid null issue)
        if (note.getTags() != null) {
            List<Tag> existingTags = note.getTags().stream()
                    .map(tag -> tagRepo.findById(tag.getId())
                            .orElseThrow(() -> new RuntimeException("Tag not found: " + tag.getId())))
                    .toList();

            note.setTags(existingTags);
        }

        return repo.save(note);
    }

    // GET ALL NOTES
    public List<Note> getAll() {
        return repo.findAll();
    }

    // 🔍 SEARCH (Title + Content)
    public List<Note> search(String keyword) {
        return repo.findByTitleContainingOrContentContaining(keyword, keyword);
    }

    // ⭐ IMPORTANT NOTES
    public List<Note> getImportantNotes() {
        return repo.findByImportantTrue();
    }

    // 👤 NOTES BY USER
    public List<Note> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}