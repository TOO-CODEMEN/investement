package com.too_codemen.application.calculations;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.calculations.Consts;
import lombok.Data;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;
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
            case "Токарные станки":
                equipment = lathes;
                break;
            case "Сверлильные и расточные станки":
                equipment = drillingBoringMachines;
                break;
            case "Фрезерные станки":
                equipment = millingMachines;
                break;
            case "Строгальные, долбёжные и протяжные станки":
                equipment = planingSlottingBroachingMachines;
                break;
            case "Шлифовальные, полировальные, доводочные станки":
                equipment = grindingPolishingFinishingMachines;
                break;
            case "Зубообрабатывающие и резьбонарезные станки":
                equipment = gearThreadCuttingMachines;
                break;
            case "Разрезные станки":
                equipment = cuttingMachines;
                break;
            case "Кузнечно-прессовое оборудование":
                equipment = forgingPressingEquipment;
                break;
            case "Электрофизическое, электрохимическое, лазерное оборудование":
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
        setResult(Precision.round((expenses.getHeadcount() * maxSalary + expenses.getHeadcount()
                * maxSalary * 0.3 + propertyTaxCount(expenses) + landTaxCount(expenses) + AccountingCost
                + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction() + getEquipment(expenses)) / 1000000, 3));
        return result;
    }

    public double resultCount(Expenses expenses) {
        setResult(Precision.round((expenses.getHeadcount() * maxSalary + expenses.getHeadcount()
                * maxSalary * 0.3 + propertyTaxCount(expenses) + landTaxCount(expenses) + AccountingCost
                + soloProprietorRegistration + capitalConstructionCost * expenses.getPlannedAreaOfConstruction() + getEquipment(expenses) + incomeTaxCount(expenses)) / 1000000,3));
        return result;
    }

    public double staffCount(Expenses expenses) {
        setStaff(Precision.round((expenses.getHeadcount() * maxSalary + sumMedicineCount(expenses) + sumPensionCount(expenses)) / 1000000, 3));
        return staff;
    }

    public double realEstateCount(Expenses expenses) {
        setRealEstate((capitalConstructionCost * expenses.getPlannedAreaOfConstruction()) / 1000000);
        return realEstate;
    }

    public double taxesCount(Expenses expenses) {

        setTaxes(Precision.round((landTaxCount(expenses) + propertyTaxCount(expenses)), 3));
        return taxes;
    }

    public double servicesCount(Expenses expenses) {
        setServices(Precision.round((AccountingCost + getTypeOfORG(expenses)) / 1000000, 3));
        return services;
    }

    public double sumMedicineCount(Expenses expenses) {

        setSumMedicine(Precision.round((expenses.getHeadcount() * medicine) / 1000000, 3));
        return sumMedicine;
    }

    public double sumPensionCount(Expenses expenses) {
        setSumPension(Precision.round((expenses.getHeadcount() * pension) / 1000000, 3));
        return sumPension;
    }

    public double landTaxCount(Expenses expenses) {
        System.out.println(expenses.getProductionSquare() * getRegion(expenses) * 1.5 / 100);
        setLandTax(expenses.getProductionSquare() * getRegion(expenses) * 1.5 / 100);
        return landTax;
    }

    public double propertyTaxCount(Expenses expenses) {
        System.out.println(expenses.getSquareOfBuilding() * getRegion(expenses) * 2.2 / 100);
        setPropertyTax(expenses.getSquareOfBuilding() * getRegion(expenses) * 2.2 / 100);
        return propertyTax;
    }

    public double incomeTaxCount(Expenses expenses) {
        setIncomeTax((expenses.getYearlyIncome() - resultCountWithoutIncome(expenses)) * 20 / 100);
        return incomeTax;
    }

}
