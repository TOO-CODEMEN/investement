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
    double region;
    double equipment;
    double typeORG;
    double staff;
    double realEstate;
    double taxes;
    double landTax;
    double propertyTax;
    double incomeTax;
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


    public double getRegion(Expenses expenses) {
        switch (expenses.getProductionArea()) {
            case "ВАО":
                region = ВАО;
                break;
            case "ЗАО":
                region = ЗАО;
                break;
            case "ЗелАО":
                region = ЗелАО;
                break;
            case "НАО":
                region = НАО;
                break;
            case "САО":
                region = САО;
                break;
            case "СВАО":
                region = СВАО;
                break;
            case "СЗАО":
                region = СЗАО;
                break;
            case "ТАО":
                region = ТАО;
                break;
            case "ЦАО":
                region = ЦАО;
                break;
            case "ЮАО":
                region = ЮАО;
                break;
            case "ЮВАО":
                region = ЮВАО;
                break;
            case "ЮЗАО":
                region = ЮЗАО;
                break;

        }

        return region;
    }

    public double getEquipment(Expenses expenses) {
        switch (expenses.getEquipment()) {
            case "ВАО":
                equipment = lathes;
                break;
            case "ЗАО":
                equipment = drillingBoringMachines;
                break;
            case "ЗелАО":
                equipment = millingMachines;
                break;
            case "НАО":
                equipment = planingSlottingBroachingMachines;
                break;
            case "САО":
                equipment = grindingPolishingFinishingMachines;
                break;
            case "СВАО":
                equipment = gearThreadCuttingMachines;
                break;
            case "СЗАО":
                equipment = cuttingMachines;
                break;
            case "ТАО":
                equipment = forgingPressingEquipment;
                break;
            case "ЦАО":
                equipment = electrophysicalElectrochemicalLaserEquipment;
                break;
        }

        return equipment;
    }

    public double getTypeOfORG(Expenses expenses) {
        System.out.println(expenses.getTypeOfOrganization());
        switch (expenses.getTypeOfOrganization()) {
            case "ИП":
                typeORG = soloProprietorRegistration;
                break;
            case "ООО (АО)":
                typeORG = juridicalPersonRegistration;
                break;

        }

        return typeORG;

    }


    public double resultCountWithoutIncome(Expenses expenses) {
        setResult(Math.round((expenses.getHeadcount() * maxSalary + expenses.getHeadcount()
                * maxSalary * 0.3 + propertyTaxCount(expenses) + landTaxCount(expenses) + AccountingCost
                + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction() + getEquipment(expenses)) / 1000000));
        return result;
    }

    public double resultCount(Expenses expenses) {
        setResult(Math.round((expenses.getHeadcount() * maxSalary + expenses.getHeadcount()
                * maxSalary * 0.3 + propertyTaxCount(expenses) + landTaxCount(expenses) + AccountingCost
                + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction() + getEquipment(expenses)) / 1000000));
        return result;
    }

    public double staffCount(Expenses expenses) {
        setStaff(Math.round((expenses.getHeadcount() * maxSalary + sumMedicineCount(expenses) + sumPensionCount(expenses)) / 1000000));
        return staff;
    }

    public double realEstateCount(Expenses expenses) {
        setRealEstate(Math.round((capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000));
        return realEstate;
    }

    public double taxesCount(Expenses expenses) {

        setTaxes(Math.round((landTaxCount(expenses) + propertyTaxCount(expenses)) / 1000000));
        return taxes;
    }

    public double servicesCount(Expenses expenses) {
        setServices(Math.round((AccountingCost ) / 1000000));
        return services;
    }

    public double sumMedicineCount(Expenses expenses) {
        setSumMedicine(Math.round((expenses.getHeadcount() * medicine) / 1000000));
        return sumMedicine;
    }

    public double sumPensionCount(Expenses expenses) {
        setSumPension(Math.round((expenses.getHeadcount() * pension) / 1000000));
        return sumPension;
    }

    public double landTaxCount(Expenses expenses) {

        setLandTax(Math.round(expenses.getProductionSquare() * getRegion(expenses) * 1.5 / 100) / 1000000);
        return landTax;
    }

    public double propertyTaxCount(Expenses expenses) {
        setLandTax(Math.round(expenses.getSquareOfBuilding() * getRegion(expenses) * 2.2 / 100) / 1000000);
        return propertyTax;
    }

    public double incomeTaxCount(Expenses expenses) {
        setIncomeTax(Math.round((expenses.getYearlyIncome() - resultCount(expenses)) * 20 / 100));
        return incomeTax;
    }

}
