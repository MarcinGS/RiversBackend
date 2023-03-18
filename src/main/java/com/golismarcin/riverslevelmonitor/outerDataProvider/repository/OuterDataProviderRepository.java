package com.golismarcin.riverslevelmonitor.outerDataProvider.repository;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.River;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuterDataProviderRepository extends JpaRepository<River, Long> {

}
