package com.too_codemen.application.calculations;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.calculations.Consts;
import org.springframework.context.annotation.Bean;

import static com.too_codemen.application.calculations.Consts.*;

public class Results {

    private Expenses expenses;
    public final double result = (expenses.getHeadcount() * maxSalary + expenses.getHeadcount() * maxSalary * 0.3 + landTaxTest + propertyTaxTest + AccountingCost + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
    public final double staff = (expenses.getHeadcount() * maxSalary) / 1000000;
    public final double realEstate = (capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
    public final double taxes = (landTaxTest + propertyTaxTest) / 1000000 ;
    public final double services = (AccountingCost + soloProprietorRegistration) / 1000000 ;

    public final double sumMedicine = expenses.getHeadcount() * medicine;
    public final double sumPension = expenses.getHeadcount() * pension;
}
