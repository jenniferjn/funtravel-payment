package id.co.bca.funtravel.payment.model;

import java.sql.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerModel {
    
    private Integer id;
    private String email;
    private String password;
    private String role;
    private String name;
    private Date dob;
    private String phoneNumber;
    private String idNumber;
    private Integer balance;
}
