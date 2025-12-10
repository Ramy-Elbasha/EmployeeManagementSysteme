package com.Ecommerce.Ecommerce_Management_System.entities;

import com.Ecommerce.Ecommerce_Management_System.DTOs.LeaveRequestsCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "RES_LEAVE_REQUESTS")
public class LeaveRequests {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;
    @Column(name = "REASON", nullable = false)
    private String reason;
    @Column(name = "status", nullable = false, length = 25)
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employeeId;

    public LeaveRequests(LeaveRequestsCreateDTO request) {
        this.startDate = request.startDate();
        this.endDate = request.endDate();
        this.reason = request.reason();
        this.status = request.Status();
    }

}
