package com.hardik.notesapi.repository;

import com.hardik.notesapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // 🔍 Search by title OR content
    List<Note> findByTitleContainingOrContentContaining(String title, String content);

    // ⭐ Important notes
    List<Note> findByImportantTrue();

    // 👤 Notes by user
    List<Note> findByUserId(Long userId);
}