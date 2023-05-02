package id.co.bca.funtravel.payment.service;

import id.co.bca.funtravel.payment.dto.PaymentDTO;
import id.co.bca.funtravel.payment.kafka.ProducerService;
import id.co.bca.funtravel.payment.model.CustomerModel;
import id.co.bca.funtravel.payment.model.PaymentModel;
import id.co.bca.funtravel.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Autowired
    WebclientService webclient;

    @Autowired
    ProducerService producer;

    @Override
    public PaymentModel insert(PaymentDTO dto, Integer customerId, String email, String password) {
        CustomerModel customer = webclient.getCustomerData(customerId, email, password);

        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid User!");
        }

        if (customer.getBalance() > dto.getTotalAmount()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Insuffient Balance!");
        }

        PaymentModel model = new PaymentModel();
        model.setOrder(dto.getOrderId());
        model.setTotalAmount(dto.getTotalAmount());
        model.setMethod(dto.getMethod());
        model.setStatus(dto.getStatus());
        model.setDate(new Date(dto.getDate()));

        return repository.save(model);
    }

    @Override
    public PaymentModel update(PaymentDTO dto, Integer paymentId) {
        PaymentModel model = repository.findPaymentById(paymentId);
        model.setOrder(dto.getOrderId());
        model.setTotalAmount(dto.getTotalAmount());
        model.setMethod(dto.getMethod());
        model.setStatus(dto.getStatus());
        model.setDate(new Date(dto.getDate()));

        if (model.getStatus().equals("complete")) {
            producer.sendMessage(model.getTotalAmount().toString());
        }
        return repository.save(model);
    }

    @Override
    public String delete(Integer paymentId) {
        try {
            repository.deleteById(paymentId);
            return "Successfully deleted payment data!";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete payment data!");
        }
    }

    @Override
    public PaymentModel getPaymentById(Integer paymentId) {
        return repository.findPaymentById(paymentId);
    }
}
