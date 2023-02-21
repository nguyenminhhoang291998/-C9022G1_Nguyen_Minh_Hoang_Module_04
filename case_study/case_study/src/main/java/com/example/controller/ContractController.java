package com.example.controller;


import com.example.dto.IContractDto;
import com.example.model.ContractDetail;
import com.example.dto.ContractDto;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;
    @RequestMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,3);
        model.addAttribute("attachFacilityList",attachFacilityService.findAll());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("facilityList",facilityService.findAll());
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("dtoPage",contractService.findAll(pageable));
        return "contract";
    }

    @RequestMapping("addContractDetail")
    public String addAttachFacility(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirect){
        contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("mess","Thêm mới hợp đồng chi tiết thành công");
        return "redirect:/contract/";
    }
}
