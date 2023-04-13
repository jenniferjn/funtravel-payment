package id.co.bca.funtravel.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "method")
    private String method;

    @Column(name = "status")
    private String status;
}
