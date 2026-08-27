package com.hmbrandt.maintenance_service.service;

import com.hmbrandt.maintenance_service.dto.*;

import java.util.List;

public interface WorkOrderService {

    WorkOrderResponseDto createOrder(WorkOrderRequestDto dto);

    WorkOrderTaskResponseDto addTask(Long workOrderId, WorkOrderTaskRequestDto taskDto);

    WorkOrderTaskResponseDto updateTask(Long id, UpdateWorkOrderTaskDto dto);

    WorkOrderResponseDto findById(Long id);

    List<WorkOrderResponseDto> findWorkOrdersByEquipmentId(Long equipmentId);

    void deleteTask(Long taskId);

    WorkOrderResponseDto updateStatus(Long id, UpdateWorkOrderStatusDto dto);

    WorkOrderResponseDto updateWorkOrder(Long id, UpdateWorkOrderDto dto);

    DashboardMetricsDTO getMetrics();

    List<KpiDetailResponseDto> getKpiDetails(KpiType type, Long equipmentId);
}
