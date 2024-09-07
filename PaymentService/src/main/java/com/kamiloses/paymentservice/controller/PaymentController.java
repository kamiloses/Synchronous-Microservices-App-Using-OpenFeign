//package com.kamiloses.paymentservice.controller;
//
//import com.kamiloses.paymentservice.service.PaymentService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/payment")
//public class PaymentController {
//
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//
//    @GetMapping
//    public Double getCurrentBalance() {
//        return paymentService.getCurrentBalance();
//    }
//
//@PostMapping
//    public String topUpWallet(@RequestHeader Double amount){
//
//        paymentService.topUpWallet(amount);
//
//
//    return "SUCCESS";}
//
//}
