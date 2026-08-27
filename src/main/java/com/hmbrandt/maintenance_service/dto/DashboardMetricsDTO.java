package com.hmbrandt.maintenance_service.dto;

public interface DashboardMetricsDTO {
    Long getPendingWorkOrders();
    Long getDueSoonMaintenances();
    Long getInProgressIssues();
    Long getCriticalOpenIssues();
}
