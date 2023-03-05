package com.golismarcin.riverslevelmonitor.note.controller;

import com.golismarcin.riverslevelmonitor.common.model.Note;
import com.golismarcin.riverslevelmonitor.note.controller.dto.NoteDto;
import com.golismarcin.riverslevelmonitor.note.service.NoteService;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.model.UserListItem;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;


    @PostMapping("/note")
    public Note addNote(@RequestBody @Valid NoteDto noteDto){
        return noteService.addNote(Note.builder()
                .topic(cleanContent(noteDto.getTopic()))
                .content(cleanContent(noteDto.getContent()))
                .userListItemId(noteDto.getUserListItemId())
                .build());
    }

    @GetMapping("/note/{userListItemId}")
    public List<NoteDto> getNotes(@AuthenticationPrincipal Long userId, @PathVariable Long userListItemId){
        UserList userList = noteService.getUserList(userId);
        UserListItem userListItem = userList.getItems().stream().filter(r -> Objects.equals(r.getId(), userListItemId)).findFirst().orElseThrow();
        return userListItem.getNote().stream().map(n -> mapToNoteDto(n)).toList();
    }

    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    private String cleanContent(String unsafeText) {
        return Jsoup.clean(unsafeText, Safelist.none());
    }

    private static NoteDto mapToNoteDto(Note note){
        return NoteDto.builder()
                .Id(note.getId())
                .topic(note.getTopic())
                .content(note.getContent())
                .userListItemId(note.getUserListItemId())
                .build();
    }

}
