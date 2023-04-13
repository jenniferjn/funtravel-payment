package id.co.bca.funtravel.payment.repository;

import id.co.bca.funtravel.payment.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {

    PaymentModel findPaymentById(Integer id);
}
