package com.example.controller;

import com.example.model.Facility;
import com.example.service.IFacilityRentTypeService;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
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

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;

    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IFacilityRentTypeService facilityRentTypeService;


    @RequestMapping("")
    public String showPageAndSearch(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                                    @RequestParam(required = false, defaultValue = "0") int typeIdSearch,
                                    @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Facility> facilityPage = facilityService.search(nameSearch, typeIdSearch, pageable);
        if (facilityPage.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy kết quả");
        }
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("facilityRentTypeList",facilityRentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("typeIdSearch", typeIdSearch);
        model.addAttribute("fcl", new Facility());
        return "facility";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Facility facility, RedirectAttributes redirect){
        facility.setFlag(true);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/facility/";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute Facility facility, RedirectAttributes redirect){
        facility.setFlag(true);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/facility/";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirect){
        Facility facility = facilityService.findById(deleteId);
        facility.setFlag(false);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/facility/";
    }
}
