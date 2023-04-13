package id.co.bca.funtravel.payment.controller;

import id.co.bca.funtravel.payment.service.PaymentService;
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
    public @ResponseBody Object addNewPayment() {
        return null;
    }

    @PutMapping("update")
    public @ResponseBody Object updatePayment() {
        return null;
    }

    @DeleteMapping("delete")
    public @ResponseBody Object deletePayment() {
        return null;
    }
}
