package com.golismarcin.riverslevelmonitor.userList.model;

import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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


}
