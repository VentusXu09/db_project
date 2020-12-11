package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CORPORATION")
@Getter
@Setter
public class Corporation extends BaseModel {

    @Column(nullable = false)
    private String corp_name;

    @Column(nullable = false)
    private String registration_no;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "corporation", cascade = CascadeType.REMOVE)
    private List<CorporationCustomer> corporationCustomers = new ArrayList<>();
}
