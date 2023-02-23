package com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.repository;

import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.River;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuterDataProviderRepository extends JpaRepository<River, Long> {
}
