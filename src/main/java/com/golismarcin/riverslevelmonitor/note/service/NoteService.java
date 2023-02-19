package com.golismarcin.riverslevelmonitor.note.service;

import com.golismarcin.riverslevelmonitor.note.model.Note;
import com.golismarcin.riverslevelmonitor.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note addNote(Note note){
       return noteRepository.save(note);
    }
}
