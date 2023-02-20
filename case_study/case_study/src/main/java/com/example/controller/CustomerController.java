package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
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
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @RequestMapping("")
    public String showPageAndSearch(Model model, @RequestParam(required = false,defaultValue = "") String nameSearch,
                                    @RequestParam(required = false,defaultValue = "") String emailSearch,
                                    @RequestParam(required = false,defaultValue = "0") int typeIdSearch,
                           @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Customer> customerPage = customerService.search(nameSearch,emailSearch,typeIdSearch,pageable);
        if (customerPage.isEmpty()){
             model.addAttribute("mess","Danh sách trống");
        }
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("emailSearch",emailSearch);
        model.addAttribute("typeIdSearch",typeIdSearch);
        model.addAttribute("ctm",new Customer());
        return "customer";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customer.setFlag(true);
        if(customerService.save(customer)){
            redirect.addFlashAttribute("mess","Thêm không thành công vì thông tin đã trùng lặp.");
        }else {
            redirect.addFlashAttribute("mess","Thêm mới thành công");
        }
        return "redirect:/customer/";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customer.setFlag(true);
        if(customerService.save(customer)){
            redirect.addFlashAttribute("mess","Sửa không thành công vì thông tin đã trùng lặp.");
        }else {
            redirect.addFlashAttribute("mess","Sửa thành công");
        }
        return "redirect:/customer/";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirect){
        Customer customer = customerService.findById(deleteId);
        customer.setFlag(false);
        customerService.save(customer);
        redirect.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/customer/";
    }
}
