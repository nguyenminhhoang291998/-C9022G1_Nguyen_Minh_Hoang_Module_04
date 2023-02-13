package com.example.controller;

import com.example.model.Book;
import com.example.model.OrderBook;
import com.example.service.IBookService;
import com.example.service.IOrderBookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOrderBookService orderBookService;

    @RequestMapping("")
    public String show(Model model){
        model.addAttribute("bookList",bookService.findAll());
        model.addAttribute("newBook",new Book());
        return "home";
    }

    @RequestMapping("order")
    public String order(@ModelAttribute("newBook") Book book, Model model, RedirectAttributes redirect) {
        int quantity = book.getQuantity();
        if(quantity == 0){
            return "error";
        }
        book.setQuantity(quantity-1);
        bookService.save(book);
        Random random = new Random();
        int orderCode =  random.nextInt(99999 - 10000 + 1) + 10000;
        orderBookService.save(new OrderBook(orderCode,book));
        redirect.addFlashAttribute("mess","Mã mượn sách là: "+orderCode);
        return "redirect:/";
    }

    @RequestMapping("giveBack")
    public String giveBack(@RequestParam int bookCode, Model model, RedirectAttributes redirect){
        OrderBook orderBook = orderBookService.findByBookCode(bookCode);
        if(orderBook == null){
            model.addAttribute("ess","Mã sách không đúng");
            return "error";
        }
        Book book = bookService.findById(orderBook.getBook().getId());
        int quantity = book.getQuantity();
        book.setQuantity(quantity+1);
        bookService.save(book);
        redirect.addFlashAttribute("mess","Trả thành công");
        return "redirect:/";
    }

}
