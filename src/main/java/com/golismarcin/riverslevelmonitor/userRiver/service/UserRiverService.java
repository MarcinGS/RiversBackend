package com.golismarcin.riverslevelmonitor.userRiver.service;

import com.golismarcin.riverslevelmonitor.userRiver.model.UserRiver;
import com.golismarcin.riverslevelmonitor.userRiver.repository.UserRiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRiverService {

    private final UserRiverRepository userRiverRepository;

    public Page<UserRiver> getRivers(Pageable pageable){
        return userRiverRepository.findAll(pageable);
    }

    public UserRiver getRiver(Long id){
        return userRiverRepository.findById(id).orElseThrow();
    }
}
