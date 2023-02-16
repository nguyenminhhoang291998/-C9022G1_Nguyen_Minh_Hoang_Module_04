package com.example.controller;

import com.example.model.dto.ContractDto;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IFacilityService facilityService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;
    @RequestMapping("")
    public String showList(Model model){
        Pageable pageable = PageRequest.of(0,3);
        model.addAttribute("attachFacilityList",attachFacilityService.findAll());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("facilityList",facilityService.findAll());
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("contractPage",contractService.findAll(pageable));
        return "contract";
    }
}
