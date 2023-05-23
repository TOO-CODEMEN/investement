package com.too_codemen.application.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "INN")
    int INN; //ИНН

    @Column(name = "industry")
    String industry;

    @Column(name = "headcount")
    int headcount;

    @Column(name = "productionArea")
    //Location Of Production
    String productionArea;

    @Column(name = "productionSquare")
    //Estimated land area production
    int productionSquare; //square meters

    @Column(name = "plannedAreaOfConstruction")
    //Planned area of capital construction
    int plannedAreaOfConstruction; //square meters

    @Column(name = "equipment")
    String equipment;

    @Column(name = "typeOfBuilding")
    String typeOfBuilding;

    @Column(name = "squareOfBuilding")
    int squareOfBuilding;

    @Column(name = "accountingServices")
    int accountingServices;

    @Column(name = "patent")
    int patent;

    @Column(name = "others")
    int others;

    @Column(name = "advancedUserId")
    Long advancedUserId;


}
