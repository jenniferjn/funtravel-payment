package id.co.bca.funtravel.payment.service;

import id.co.bca.funtravel.payment.dto.PaymentDTO;
import id.co.bca.funtravel.payment.model.PaymentModel;

public interface PaymentService {

    PaymentModel insert(PaymentDTO dto, Integer customerId, String email, String password);

    PaymentModel update(PaymentDTO dto, Integer paymentId);

    String delete(Integer paymentId);

    PaymentModel getPaymentById(Integer paymentId);
}
