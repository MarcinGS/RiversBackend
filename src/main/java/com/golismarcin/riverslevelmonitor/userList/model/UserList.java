package com.golismarcin.riverslevelmonitor.userList.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userListId")
    private List<UserListItem> items;

    public void addRiver(UserListItem userListItem){
        if(items == null){
            items = new ArrayList<>();
        }
        items.add(userListItem);
    }

}
