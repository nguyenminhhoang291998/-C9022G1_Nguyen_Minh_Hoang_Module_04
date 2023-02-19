package com.example.controller;

import com.example.model.ContractDetail;
import com.example.model.dto.ContractDto;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    IContractDetailDtoService contractDetailDtoService;

    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IDtoService dtoService;
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
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("dtoPage",dtoService.findAllDto(pageable));
        return "contract";
    }

    @RequestMapping("addContractDetail")
    public String addAttachFacility(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirect){
        contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("mess","Thêm mới hợp đồng chi tiết thành công");
        return "redirect:/contract/";
    }
}
