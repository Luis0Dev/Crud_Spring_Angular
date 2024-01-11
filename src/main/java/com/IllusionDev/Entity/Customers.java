package com.IllusionDev.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="customers")

public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;


}
