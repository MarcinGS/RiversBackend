package com.golismarcin.riverslevelmonitor.note.model.dto;

import org.hibernate.validator.constraints.Length;

public record NoteDto(@Length(min = 2, max = 60) String topic, @Length(min = 4, max = 600) String content, Long riverId){
}



