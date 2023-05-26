package com.too_codemen.application.calculations;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.calculations.Consts;

import static com.too_codemen.application.calculations.Consts.*;


public class Results {

    static Expenses expenses;
    public static final double result = (expenses.getHeadcount() * maxSalary + expenses.getHeadcount() * maxSalary * 0.3 + landTaxTest + propertyTaxTest + AccountingCost + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
    public static final double staff = (expenses.getHeadcount() * maxSalary) / 1000000 ;
    public static final double realEstate = (capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
    public static final double taxes = (landTaxTest + propertyTaxTest) / 1000000 ;
    public static final double services = (AccountingCost + soloProprietorRegistration) / 1000000 ;

    public static final double sumMedicine = expenses.getHeadcount() * medicine;
    public static final double sumPension = expenses.getHeadcount() * pension;
}
