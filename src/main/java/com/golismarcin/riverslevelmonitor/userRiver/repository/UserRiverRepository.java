package com.golismarcin.riverslevelmonitor.userRiver.repository;

import com.golismarcin.riverslevelmonitor.common.model.UserRiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRiverRepository extends JpaRepository<UserRiver, Long> {

    Optional<UserRiver> findUserRiverByStationId(Long stationId);

}
