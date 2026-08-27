package com.hmbrandt.maintenance_service.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_preventive_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE equipment_preventive_schedules SET deleted_at = NOW() WHERE equipment_preventive_schedule_id = ?")
@SQLRestriction("deleted_at IS NULL")
public class PreventiveSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_preventive_schedule_id")
    private Long id;

    @Column(name = "preventive_plan_id")
    private Long preventivePlanId;

    @Column(name = "equipment_id", nullable = false)
    private Long equipmentId;

    @Column(name = "last_performed_date")
    private LocalDate lastPerformedDate;

    @Column(name = "last_performed_meter")
    private BigDecimal lastPerformedMeter;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "due_meter")
    private BigDecimal dueMeter;

    @Builder.Default
    @Column(name = "is_overdue")
    private Boolean isOverdue = false;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
