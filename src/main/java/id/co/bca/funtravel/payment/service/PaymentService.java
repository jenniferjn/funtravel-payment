package id.co.bca.funtravel.payment.service;

import id.co.bca.funtravel.payment.model.Payment;

public interface PaymentService {

    void insert(Payment payment);

    void update(Payment payment);

    void delete(Integer paymentId);

    Payment getPaymentById(Integer paymentId);
}
