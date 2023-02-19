package com.golismarcin.riverslevelmonitor.note.controller;

import com.golismarcin.riverslevelmonitor.note.model.Note;
import com.golismarcin.riverslevelmonitor.note.model.dto.NoteDto;
import com.golismarcin.riverslevelmonitor.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/note")
    public Note addNote(@RequestBody @Valid NoteDto noteDto){
        return noteService.addNote(Note.builder()
                .topic(cleanContent(noteDto.topic()))
                .content(cleanContent(noteDto.content()))
                .riverId(noteDto.riverId())
                .build());
    }

    private String cleanContent(String unsafeText) {
        return Jsoup.clean(unsafeText, Safelist.none());
    }


}
