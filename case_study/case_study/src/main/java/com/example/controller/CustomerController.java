package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
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
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @RequestMapping("")
    public String showPageAndSearch(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                                    @RequestParam(required = false, defaultValue = "") String emailSearch,
                                    @RequestParam(required = false, defaultValue = "0") int typeIdSearch,
                                    @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Customer> customerPage = customerService.search(nameSearch, emailSearch, typeIdSearch, pageable);
        if (customerPage.isEmpty()) {
            model.addAttribute("mess", "Danh sách trống");
        }
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("typeIdSearch", typeIdSearch);
        if(model.getAttribute("customerDto")!= null){
            model.addAttribute("customerDto",model.getAttribute("customerDto"));
            model.addAttribute("hasError", "true");
        }else {
            model.addAttribute("customerDto", new CustomerDto());
            model.addAttribute("hasError", "false");
        }
        return "customer";
    }

    @RequestMapping("save")
    public String save(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                        RedirectAttributes redirect, @RequestParam(required = false, defaultValue = "") String nameSearch,
                       @RequestParam(required = false, defaultValue = "") String emailSearch,
                       @RequestParam(required = false, defaultValue = "0") int typeIdSearch,
                       @RequestParam(required = false, defaultValue = "0") int page) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("customerPage", customerService.search("", "", 0, PageRequest.of(0, 2)));
//            model.addAttribute("customerTypeList", customerTypeService.findAll());
            redirect.addFlashAttribute("customerDto", customerDto);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.customerDto",bindingResult);
            return "redirect:/customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        // nếu người dùng cố tình truyền vào 1 Id đã có sẵn
        if (customerService.findById(customer.getId()) != null) {
            redirect.addFlashAttribute("mess", "Id không được trùng lặp.");
            return "redirect:/customer/";
        }
        if (customerService.save(customer)) {
            redirect.addFlashAttribute("mess", "Thêm mới thành công");
        } else {
            redirect.addFlashAttribute("mess","Thêm không thành công vì thông tin đã trùng lặp." );
        }
        return "redirect:/customer/";
    }

    @RequestMapping("update")
    public String update(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                         Model model, RedirectAttributes redirect) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerPage", customerService.search("", "", 0, PageRequest.of(0, 2)));
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            model.addAttribute("hasErr", "true");
            return "customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        // nếu người dùng cố tình truyền vào 1 Id không có trong danh sách
        if (customerService.findById(customer.getId()) == null) {
            redirect.addFlashAttribute("mess", "Không tìm thấy Id.");
            return "redirect:/customer/";
        }
        if (customerService.update(customer)) {
            redirect.addFlashAttribute("mess", "Sửa thành công");
        } else {
            redirect.addFlashAttribute("mess", "Sửa không thành công vì thông tin đã trùng lặp.");
        }
        return "redirect:/customer/";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirect) {
        Customer customer = customerService.findById(deleteId);
        // nếu người dùng cố tình truyền vào Id không tồn tại
        if (customer == null) {
            redirect.addFlashAttribute("mess", "Xóa không thành công");
            return "redirect:/customer/";
        }
        customerService.delete(customer);
        redirect.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer/";
    }
}
