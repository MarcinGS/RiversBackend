package com.golismarcin.riverslevelmonitor.river.service;

import com.golismarcin.riverslevelmonitor.river.model.River;
import com.golismarcin.riverslevelmonitor.river.repository.RiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiverService {

    private final RiverRepository riverRepository;

    public Page<River> getRivers(Pageable pageable){
        return riverRepository.findAll(pageable);
    }
}
