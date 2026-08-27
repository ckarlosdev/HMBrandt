package com.hmbrandt.maintenance_service.dto;

public record UpdateWorkOrderDto(
        Long equipmentId,
        String orderType,
        Double totalCost,
        String userName
) {
}
