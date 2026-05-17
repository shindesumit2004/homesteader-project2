package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Government_Scheme")
public class GovernmentScheme {

    @Id
    private int id;
    private String schemeName;
    private String description;
    private String eligibility;
    private String department;
    private String benefits;
    private String applicationMode;
    private String officialWebsite;
    private String requiredDocument;
    private String lastDate;

}
