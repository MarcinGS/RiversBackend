package com.golismarcin.riverslevelmonitor.river.repository;

import com.golismarcin.riverslevelmonitor.river.model.River;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiverRepository extends JpaRepository<River, Long> {

}
