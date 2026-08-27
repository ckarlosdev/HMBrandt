package com.hmbrandt.maintenance_service.service;


import com.hmbrandt.maintenance_service.dto.PreventiveScheduleRequestDto;
import com.hmbrandt.maintenance_service.dto.PreventiveScheduleResponseDto;
import com.hmbrandt.maintenance_service.dto.PreventiveScheduleResponseProjection;

import java.util.List;

public interface PreventiveScheduleService {
    PreventiveScheduleResponseDto save(PreventiveScheduleRequestDto dto);

    PreventiveScheduleResponseDto update(Long id, PreventiveScheduleRequestDto dto);

    PreventiveScheduleResponseDto findById(Long id);

    List<PreventiveScheduleResponseDto> findByEquipmentId(Long JobId);

    void delete(Long id);

    List<PreventiveScheduleResponseProjection> getActiveSchedulesForEquipments(List<Long> equipmentIds);
}
