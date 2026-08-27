package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;

public record KpiDetailResponseDto (
    Long id,
    Long equipmentId,
    String title,
    String subtitle,
    String status,
    String severity,
    LocalDateTime date
){
}
