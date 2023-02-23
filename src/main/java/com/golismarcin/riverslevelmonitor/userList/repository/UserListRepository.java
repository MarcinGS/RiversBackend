package com.golismarcin.riverslevelmonitor.userList.repository;

import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<UserList, Long> {

}
