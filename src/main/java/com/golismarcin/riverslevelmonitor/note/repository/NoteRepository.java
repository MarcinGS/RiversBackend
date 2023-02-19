package com.golismarcin.riverslevelmonitor.note.repository;

import com.golismarcin.riverslevelmonitor.common.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
