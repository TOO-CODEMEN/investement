package com.too_codemen.application.calculations;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.calculations.Consts;
import lombok.Data;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static com.too_codemen.application.calculations.Consts.*;

@Data
@Setter
public class Results {

//    private Expenses expenses;
    double result;
    double staff;
    double realEstate;
    double taxes;
    double services;
    double sumMedicine;
    double sumPension;
//    public final double result = (expenses.getHeadcount() * maxSalary + expenses.getHeadcount() * maxSalary * 0.3 + landTaxTest + propertyTaxTest + AccountingCost + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
//    public final double staff = (expenses.getHeadcount() * maxSalary) / 1000000;
//    public final double realEstate = (capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000 ;
//    public final double taxes = (landTaxTest + propertyTaxTest) / 1000000 ;
//    public final double services = (AccountingCost + soloProprietorRegistration) / 1000000 ;
//
//    public final double sumMedicine = expenses.getHeadcount() * medicine;
//    public final double sumPension = expenses.getHeadcount() * pension;

    public double resultCount(Expenses expenses) {
        setResult(expenses.getHeadcount() * maxSalary + expenses.getHeadcount()
                * maxSalary * 0.3 + landTaxTest + propertyTaxTest + AccountingCost
                + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction() / 1000000);
        return result;
    }
    public double staffCount(Expenses expenses) {
        setStaff((expenses.getHeadcount() * maxSalary + sumMedicineCount(expenses) + sumPensionCount(expenses)) / 1000000);
        return staff;
    }

    public double realEstateCount(Expenses expenses) {
        setRealEstate((capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000);
        return realEstate;
    }

    public double taxesCount() {
        setTaxes((landTaxTest + propertyTaxTest) / 1000000);
        return taxes;
    }

    public double servicesCount() {
        setServices((AccountingCost + soloProprietorRegistration) / 1000000);
        return services;
    }

    public double sumMedicineCount(Expenses expenses) {
        setSumMedicine(expenses.getHeadcount() * medicine);
        return sumMedicine;
    }

    public double sumPensionCount(Expenses expenses) {
        setSumPension(expenses.getHeadcount() * pension);
        return sumPension;
    }
}
