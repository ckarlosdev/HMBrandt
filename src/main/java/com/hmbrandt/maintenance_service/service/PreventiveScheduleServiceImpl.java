package com.hmbrandt.maintenance_service.service;



import com.hmbrandt.maintenance_service.dto.PreventiveScheduleRequestDto;
import com.hmbrandt.maintenance_service.dto.PreventiveScheduleResponseDto;
import com.hmbrandt.maintenance_service.dto.PreventiveScheduleResponseProjection;
import com.hmbrandt.maintenance_service.entity.PreventiveSchedule;
import com.hmbrandt.maintenance_service.repository.PreventiveScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreventiveScheduleServiceImpl implements PreventiveScheduleService {

        private final PreventiveScheduleRepository preventiveScheduleRepository;

        @Override
        @Transactional
        public PreventiveScheduleResponseDto save(PreventiveScheduleRequestDto dto){
            PreventiveSchedule newSchedule = new PreventiveSchedule();

            newSchedule.setPreventivePlanId(dto.preventivePlanId());
            newSchedule.setEquipmentId(dto.equipmentId());
            newSchedule.setLastPerformedDate(dto.lastPerformedDate());
            newSchedule.setLastPerformedMeter(dto.lastPerformedMeter());
            newSchedule.setDueDate(dto.dueDate());
            newSchedule.setDueMeter(dto.dueMeter());
            newSchedule.setIsOverdue(false);
            newSchedule.setCreatedBy(dto.userName());
            newSchedule.setUpdatedBy(dto.userName());


            PreventiveSchedule savedSchedule = preventiveScheduleRepository.save(newSchedule);

            return mapScheduleToDto(savedSchedule);
        }

    @Override
    @Transactional
    public PreventiveScheduleResponseDto update(Long id, PreventiveScheduleRequestDto dto){
        PreventiveSchedule schedule = preventiveScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Issue not found with ID: "+id));

        schedule.setEquipmentId(dto.equipmentId());
        schedule.setLastPerformedDate(dto.lastPerformedDate());
        schedule.setLastPerformedMeter(dto.lastPerformedMeter());
        schedule.setDueDate(dto.dueDate());
        schedule.setDueMeter(dto.dueMeter());
        schedule.setIsOverdue(false);
        schedule.setCreatedBy(dto.userName());
        schedule.setUpdatedBy(dto.userName());

        PreventiveSchedule savedSchedule = preventiveScheduleRepository.save(schedule);

        return mapScheduleToDto(savedSchedule);
    }

    @Override
    @Transactional
    public PreventiveScheduleResponseDto findById(Long id){
        PreventiveSchedule schedule = preventiveScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by ID: "+id));

        return mapScheduleToDto(schedule);
    }

    @Override
    @Transactional
    public List<PreventiveScheduleResponseDto> findByEquipmentId(Long equipmentId){
        return preventiveScheduleRepository.findByEquipmentId(equipmentId)
                .stream()
                .map(this::mapScheduleToDto)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long id){
        if(!preventiveScheduleRepository.existsById(id)){
            throw new EntityNotFoundException("Id not found");
        }
        preventiveScheduleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreventiveScheduleResponseProjection> getActiveSchedulesForEquipments(List<Long> equipmentIds) {
        if (equipmentIds == null || equipmentIds.isEmpty()) {
            return Collections.emptyList();
        }
        return preventiveScheduleRepository.findActiveSchedulesByEquipmentIds(equipmentIds);
    }


    private PreventiveScheduleResponseDto mapScheduleToDto(PreventiveSchedule entity){
        return new PreventiveScheduleResponseDto(
                entity.getId(),
                entity.getPreventivePlanId(),
                entity.getEquipmentId(),
                entity.getLastPerformedDate(),
                entity.getLastPerformedMeter(),
                entity.getDueDate(),
                entity.getDueMeter(),
                entity.getIsOverdue()
                );
    }
}
