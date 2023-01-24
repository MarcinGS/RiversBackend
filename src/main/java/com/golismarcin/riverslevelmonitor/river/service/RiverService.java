package com.golismarcin.riverslevelmonitor.river.service;

import com.golismarcin.riverslevelmonitor.river.model.River;
import com.golismarcin.riverslevelmonitor.river.repository.RiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiverService {

    private final RiverRepository riverRepository;

    public List<River> getRivers(){
        return riverRepository.findAll();
    }
}
