package com.golismarcin.riverslevelmonitor.userList.repository;

import com.golismarcin.riverslevelmonitor.userList.model.UserListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListItemRepository extends JpaRepository<UserListItem, Long> {

    Long countByUserListId(Long userListId);
}
