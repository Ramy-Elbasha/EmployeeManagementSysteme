package com.Ecommerce.Ecommerce_Management_System.controllers;

import com.Ecommerce.Ecommerce_Management_System.abstracts.LeaveRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveRequestsController {
    @Autowired
    LeaveRequestsService leaveRequestsService;

}
