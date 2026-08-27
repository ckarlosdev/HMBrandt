package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;

public interface EquipmentIssueProjection {
    Long getId();
    Long getEquipmentId();
    String getReportedBy();
    LocalDateTime getReportedAt();
    String getIssueDescription();
    String getSeverity();
    String getIssueStatus();
    Long getWorkOrderId();
    String getOrderType();
    String getOrderStatus();
}
