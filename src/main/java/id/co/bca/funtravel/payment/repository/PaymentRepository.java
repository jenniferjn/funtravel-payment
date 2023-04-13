package id.co.bca.funtravel.payment.repository;

import id.co.bca.funtravel.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findPaymentById(Integer id);
}
