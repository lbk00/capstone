package com.example.capstone.Supplier;



import javax.persistence.*;

@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column(nullable = false, length = 20)
    private String supplierName;

    @Column(nullable = false, length = 20)
    private String supplierAdr;

    @Column(nullable = false)
    private int supplierTel;

    @Column(nullable = false)
    private int managerTel;

    @Column(nullable = false, length = 20)
    private String managerName;

    // getters and setters
}