package com.golismarcin.riverslevelmonitor.region.model;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.model.AdminRiver;
import org.springframework.data.domain.Page;

public record RegionRiverDto(Region region, Page<AdminRiver> rivers) {
}
