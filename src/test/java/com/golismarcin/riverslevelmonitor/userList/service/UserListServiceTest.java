package com.golismarcin.riverslevelmonitor.userList.service;

import com.golismarcin.riverslevelmonitor.common.repository.AdminRiverRepository;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrivateListServiceTest {

    @Mock
    private UserListRepository privateListRepository;
    @Mock
    private  AdminRiverRepository adminRiverRepository;
    @InjectMocks
    private UserListRepository privateListService;

//    @Test
//    void shouldAddRiverToUserListWhenUserListIdNotExists(){
//        //given
//        Long userListId = 0L;
//        UserListDto userListDto = new UserListDto(1L);
//        when(adminRiverRepository.findById(1L)).thenReturn(Optional.of(AdminRiver.builder().id(1L).build()));
//        when(userListRepository.save(any())).thenReturn(UserList.builder().id(1L).build());
//        //when
//        UserList userList = userListService.addRiverToUserList(userListId, userListDto);
//        //then
//        assertThat(userList).isNotNull();
//        assertThat(userList.getId()).isEqualTo(1L);
//    }
//
//    @Test
//    void shouldAddRiverToUserListWhenUserListIdExists(){
//        //given
//        Long userListId = 1L;
//        UserListDto userListDto = new UserListDto(1L);
//        when(adminRiverRepository.findById(1L)).thenReturn(Optional.of(AdminRiver.builder().id(1L).build()));
//        when(userListRepository.findById(userListId)).thenReturn(Optional.of(UserList.builder().id(1L).build()));
//        //when
//        UserList userList = userListService.addRiverToUserList(userListId, userListDto);
//        //then
//        assertThat(userList).isNotNull();
//        assertThat(userList.getId()).isEqualTo(1L);
//    }

}