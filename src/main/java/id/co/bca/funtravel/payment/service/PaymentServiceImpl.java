package id.co.bca.funtravel.payment.service;

import id.co.bca.funtravel.payment.model.Payment;
import id.co.bca.funtravel.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public void insert(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void update(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void delete(Integer paymentId) {
        repository.deleteById(paymentId);
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        return repository.findPaymentById(paymentId);
    }
}
