//package com.kamiloses.paymentservice.service;
//
//import com.kamiloses.paymentservice.repository.PaymentRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//private final PaymentRepository paymentRepository;
//private final FeignUserService feignUserService;
//    public PaymentService(PaymentRepository paymentRepository, FeignUserService feignUserService) {
//        this.paymentRepository = paymentRepository;
//        this.feignUserService = feignUserService;
//    }
//
//    public Double getCurrentBalance(){
//        Long loggedUserId = feignUserService.getLoggedUserId();
//        PaymentEntity paymentEntity = paymentRepository.findById(loggedUserId).get();
//        return paymentEntity.getMoney();
//
//    }
//
//    public void topUpWallet(Double amount){//header
//        Long loggedUserId = feignUserService.getLoggedUserId();
//        PaymentEntity paymentEntity = paymentRepository.findById(loggedUserId).get();
//        paymentEntity.setMoney(paymentEntity.getMoney()+amount);
//
//
//    }
//
//
//
//
//
//}
