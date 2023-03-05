package com.golismarcin.riverslevelmonitor.userList.model;

import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.common.model.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private AdminRiver river;
    private Long userListId;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userListItemId")
    private List<Note> note;
}
