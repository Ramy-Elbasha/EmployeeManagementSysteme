package com.Ecommerce.Ecommerce_Management_System.services;

import com.Ecommerce.Ecommerce_Management_System.DTOs.LeaveRequestsCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.EmployeeSerivce;
import com.Ecommerce.Ecommerce_Management_System.abstracts.LeaveRequestsService;
import com.Ecommerce.Ecommerce_Management_System.entities.Employee;
import com.Ecommerce.Ecommerce_Management_System.entities.LeaveRequests;
import com.Ecommerce.Ecommerce_Management_System.repositories.LeaveRequestsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestsServiceImp implements LeaveRequestsService {
    @Autowired
    LeaveRequestsRepo leaveRequestsRepo;
    @Autowired
    EmployeeSerivce employeeSerivce;

    @Override
    public LeaveRequests findOne(UUID leaveId) {
        return leaveRequestsRepo.findById(leaveId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
    }

    @Override
    public List<LeaveRequests> findAll() {
        return leaveRequestsRepo.findAll();
    }

    @Override
    public List<LeaveRequests> findAllByEmployeeId(UUID employeeId) {
        return List.of();
    }

    @Override
    public void deleteOne(UUID leaveId) {
        LeaveRequests request = leaveRequestsRepo.findById(leaveId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        leaveRequestsRepo.deleteById(leaveId);
    }

    @Override
    public LeaveRequests create(LeaveRequestsCreateDTO request, UUID employeeId) {
        LeaveRequests newRequest = new LeaveRequests(request);
        Employee emp = employeeSerivce.findOne(employeeId);
        newRequest.setEmployeeId(emp);
        return leaveRequestsRepo.save(newRequest);
    }
}
