package com.too_codemen.application.model;

import lombok.*;

import javax.persistence.*;

@Data
public class Expenses {

    Long id;

    int yearlyIncome;

    String industry;

    String typeOfOrganization;

    int headcount;

    //Location Of Production
    String productionArea;

    //Estimated land area production
    int productionSquare; //square meters

    //Planned area of capital construction
    int plannedAreaOfConstruction; //square meters

    String equipment;

    String typeOfBuilding;

    int squareOfBuilding;

    int accountingServices;


    //ToDo: добавить тип организации

}
