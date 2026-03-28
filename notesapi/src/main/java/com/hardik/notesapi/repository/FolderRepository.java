package com.hardik.notesapi.repository;

import com.hardik.notesapi.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}