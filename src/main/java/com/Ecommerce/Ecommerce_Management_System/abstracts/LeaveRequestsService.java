package com.Ecommerce.Ecommerce_Management_System.abstracts;

import com.Ecommerce.Ecommerce_Management_System.DTOs.LeaveRequestsCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.entities.LeaveRequests;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestsService {
    LeaveRequests findOne(UUID leaveId);

    List<LeaveRequests> findAll();

    List<LeaveRequests> findAllByEmployeeId(UUID employeeId);


    void deleteOne(UUID leaveId);


    public LeaveRequests create(LeaveRequestsCreateDTO request, UUID employeeId);
}
