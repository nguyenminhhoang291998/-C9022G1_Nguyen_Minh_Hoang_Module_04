package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Component
@Aspect
public class Logger {
    static int count = 0;
    static int count1 = 0;

    @Pointcut("execution(* com.example.controller.BookController.order(..))" +
            "||execution(* com.example.controller.BookController.giveBack(..))")
    public void handleChangeLibrary(){
    }
    @After(value = "handleChangeLibrary()" )
    public void getChangeLibrary(){
        System.out.println("Số lần trạng thái của thư viện bị thay đổi là: " + (++count));
    }


    @Pointcut("execution(* com.example.controller.BookController.*(..))")
    public void handleShowFn(){
    }

    @After(value = "handleShowFn()")
    public void getAll(){
        System.out.println("Số lượng người đã ghé thăm thư viện sách: " + (++count1));
    }
}
