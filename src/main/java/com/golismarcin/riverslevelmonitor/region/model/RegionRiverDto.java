package com.golismarcin.riverslevelmonitor.region.model;

import com.golismarcin.riverslevelmonitor.userRiver.controller.dto.UserRiverListDto;
import org.springframework.data.domain.Page;

public record RegionRiverDto(Region region, Page<UserRiverListDto> rivers) {
}
