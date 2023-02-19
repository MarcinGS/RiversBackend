package com.golismarcin.riverslevelmonitor.region.dto;

import com.golismarcin.riverslevelmonitor.common.dto.UserRiverListDto;
import com.golismarcin.riverslevelmonitor.common.model.Region;
import org.springframework.data.domain.Page;

public record RegionRiverDto(Region region, Page<UserRiverListDto> rivers) {
}
