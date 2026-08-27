package com.hmbrandt.maintenance_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PreventiveScheduleResponseProjection {
    Long getEquipmentPreventiveScheduleId();
    Long getPreventivePlanId();
    Long getEquipmentId();
    LocalDate getLastPerformedDate();
    BigDecimal getLastPerformedMeter();
    LocalDate getDueDate();
    BigDecimal getDueMeter();
    Boolean getIsOverdue();
    Long getWorkOrderId();
    String getOrderStatus();
    Boolean getIsCompleted();
    String getScheduleStatus();
}
