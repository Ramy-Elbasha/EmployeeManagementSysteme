package com.Ecommerce.Ecommerce_Management_System.repositories;

import com.Ecommerce.Ecommerce_Management_System.entities.LeaveRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeaveRequestsRepo extends JpaRepository<LeaveRequests, UUID> {
}
