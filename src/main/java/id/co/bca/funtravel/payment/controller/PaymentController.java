package id.co.bca.funtravel.payment.controller;

import id.co.bca.funtravel.payment.dto.PaymentDTO;
import id.co.bca.funtravel.payment.service.PaymentService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @GetMapping("")
    public @ResponseBody Object getCustomerById(@RequestParam("id") Integer userId) {
        return service.getPaymentById(userId);
    }

    @PostMapping("add")
    public @ResponseBody Object addNewPayment(ServletRequest servletRequest, @RequestBody PaymentDTO payment) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            return service.insert(payment, Integer.parseInt(request.getHeader("user")), request.getHeader("email"), request.getHeader("password"));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("update")
    public @ResponseBody Object updatePayment(@RequestBody PaymentDTO payment, @RequestParam("id") Integer paymentId) {
        return service.update(payment, paymentId);
    }

    @DeleteMapping("delete")
    public @ResponseBody Object deletePayment(@RequestParam("id") Integer paymentId) {
        return service.delete(paymentId);
    }
}
