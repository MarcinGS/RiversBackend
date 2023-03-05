package com.golismarcin.riverslevelmonitor.note.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private long Id;
    @Length(min = 2, max = 60)
    private String topic;
    @Length(min = 4, max = 600)
    private String content;
    private Long userListItemId;
}



