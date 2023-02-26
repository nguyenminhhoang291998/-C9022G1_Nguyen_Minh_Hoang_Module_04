package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.Facility;
import com.example.service.IFacilityRentTypeService;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IFacilityRentTypeService facilityRentTypeService;


    @RequestMapping("")
    public String showPageAndSearch(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                                    @RequestParam(required = false, defaultValue = "0") int typeIdSearch,
                                    @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Facility> facilityPage = facilityService.search(nameSearch, typeIdSearch, pageable);
        if (facilityPage.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy kết quả");
        }
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("facilityRentTypeList",facilityRentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("typeIdSearch", typeIdSearch);
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility";
    }

    @RequestMapping("save")
    public String save(@Valid @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult,
                       RedirectAttributes redirect, Model model){
        new FacilityDto().validate(facilityDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityPage",facilityService.search("",0,PageRequest.of(0,2)));
            model.addAttribute("facilityTypeList",facilityTypeService.findAll());
            model.addAttribute("facilityRentTypeList",facilityRentTypeService.findAll());
            model.addAttribute("facilityDto",facilityDto);
            model.addAttribute("hasError","true");
            return "facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facility.setCost(Double.parseDouble(facilityDto.getCost()));
        // nếu người dùng cố tình truyền vào 1 Id đã có sẵn
        if(facilityService.findById(facility.getId())!=null){
            redirect.addFlashAttribute("mess", "Id không được trùng lặp.");
            return "redirect:/facility/";
        }
        if(facilityService.save(facility)){
            redirect.addFlashAttribute("mess", "Thêm mới thành công");
        } else {
            redirect.addFlashAttribute("mess","Thêm không thành công vì thông tin đã trùng lặp." );
        }
        return "redirect:/facility/";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute FacilityDto facilityDto,BindingResult bindingResult,
                         RedirectAttributes redirect, Model model){
        new FacilityDto().validate(facilityDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityPage",facilityService.search("",0,PageRequest.of(0,2)));
            model.addAttribute("facilityTypeList",facilityTypeService.findAll());
            model.addAttribute("facilityRentTypeList",facilityRentTypeService.findAll());
            model.addAttribute("facilityDto",facilityDto);
            model.addAttribute("hasErr","true");
            return "facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facility.setCost(Double.parseDouble(facilityDto.getCost()));
        // nếu người dùng cố tình truyền vào 1 Id không có trong danh sách
        if(facilityService.findById(facility.getId())==null){
            redirect.addFlashAttribute("mess", "Không tìm thấy Id.");
            return "redirect:/facility/";
        }
        if(facilityService.update(facility)){
            redirect.addFlashAttribute("mess", "Sửa thành công");
        } else {
            redirect.addFlashAttribute("mess","Sửa không thành công vì thông tin đã trùng lặp." );
        }
        return "redirect:/facility/";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirect){
        Facility facility = facilityService.findById(deleteId);
        // nếu người dùng cố tình truyền vào Id không tồn tại
        if (facility == null) {
            redirect.addFlashAttribute("mess", "Xóa không thành công");
            return "redirect:/facility/";
        }
        facilityService.delete(facility);
        redirect.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/facility/";
    }
}
