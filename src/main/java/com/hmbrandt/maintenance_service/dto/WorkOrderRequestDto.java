package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public record WorkOrderRequestDto(
   Long equipmentId,
   String orderType,
   String createdBy,
   List<WorkOrderTaskRequestDto> tasks
) {}
