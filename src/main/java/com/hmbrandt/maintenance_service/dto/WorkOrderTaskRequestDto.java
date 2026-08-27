package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;

public record WorkOrderTaskRequestDto(
        String taskDescription,
        Long preventivePlanId,
        Long equipmentIssueId,
        String createdBy
) {}
