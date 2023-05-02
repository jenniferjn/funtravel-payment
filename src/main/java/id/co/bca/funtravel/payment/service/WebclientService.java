package id.co.bca.funtravel.payment.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import id.co.bca.funtravel.payment.model.CustomerModel;

@Service
public class WebclientService {
    
    private RestTemplate restTemplate;

    public WebclientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String customerUrl = "http://localhost:8080";

    public CustomerModel getCustomerData(Integer customerId, String email, String password) {
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(email, password));
        ResponseEntity<CustomerModel> response = restTemplate.exchange(customerUrl + "/customer?id={id}", HttpMethod.GET, null, CustomerModel.class, customerId);
        return response.getBody();
    }
}
