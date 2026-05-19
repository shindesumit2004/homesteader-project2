package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Government_Scheme")
public class GovernmentScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schemeName;
    private String schemeType;
    private String departmentName;
    @Column(length = 3000)
    private String description;
    private String stateName;
    private String eligibility;
    private String subsidyAmount;
    private String benefits;
    private String applicationMode;
    private String officialWebsite;
    private String contactNumber;
    private String requiredDocuments;
    @Column(length = 3000)
    private String applicationProcess;
    private String lastDate;
    private String status;
    private String image;

}
