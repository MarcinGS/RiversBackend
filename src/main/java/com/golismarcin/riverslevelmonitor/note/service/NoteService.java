package com.golismarcin.riverslevelmonitor.note.service;

import com.golismarcin.riverslevelmonitor.common.model.Note;
import com.golismarcin.riverslevelmonitor.note.repository.NoteRepository;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserListRepository userListRepository;


    public Note addNote(Note note){
       return noteRepository.save(note);
    }
    public UserList getUserList(Long userId){
        return userListRepository.findByUserId(userId);
    }

    public void deleteNote(Long id) {
         noteRepository.deleteById(id);
    }
}
