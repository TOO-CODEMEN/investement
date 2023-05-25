package com.too_codemen.application.model;

import com.too_codemen.application.model.Expenses;
public class Consts {

    static Expenses expenses;

    //1 square meter
    public static final double ВАО = 15492.36;
    public static final double ЗАО = 11703.22;
    public static final double ЗелАО = 4111.50;
    public static final double НАО = 5333.94;
    public static final double САО = 20532.99;
    public static final double СВАО = 19485.33;
    public static final double СЗАО = 19961.59;
    public static final double ТАО = 2890.51;
    public static final double ЦАО = 63274.79;
    public static final double ЮАО = 13510.37;
    public static final double ЮВАО = 14086.97;
    public static final double ЮЗАО = 16423.10;
    public static final double capitalConstructionCost = 120000;



    // machine tools

    public static final double lathes= 2590991.653;
    public static final double drillingBoringMachines = 2559497.109;
    public static final double millingMachines = 3845923.242;
    public static final double planingSlottingBroachingMachines = 3150656.0695;
    public static final double grindingPolishingFinishingMachines = 4481440.152;
    public static final double gearThreadCuttingMachines = 5258960.304;
    public static final double сuttingMachines = 562505.4915;
    public static final double forgingPressingEquipment = 2829654.58;
    public static final double electrophysicalElectrochemicalLaserEquipment = 9930022.921;

    //average salary per worker

    public static final double milkFoodIndustry = 85.5960103574483 * 1000;

    //taxes
    public static final double landTaxTest = 1000*ВАО*1.5/100;
    public static final double propertyTaxTest = expenses.squareOfBuilding*ВАО*2.2/100;

    //per month
    public static final double AccountingCost = 35000;

    public static final double soloProprietorRegistration = 800;

    public static final double juridicalPersonRegistration = 4000;


    //Result
    public static final double result = (expenses.headcount * milkFoodIndustry + landTaxTest + propertyTaxTest + AccountingCost + soloProprietorRegistration + capitalConstructionCost * expenses.plannedAreaOfConstruction) / 1000 ;
    public static final double staff = (expenses.headcount * milkFoodIndustry) / 1000 ;
    public static final double realEstate = (capitalConstructionCost * expenses.plannedAreaOfConstruction) / 1000 ;
    public static final double taxes = (landTaxTest + propertyTaxTest) / 1000 ;
    public static final double services = (AccountingCost + soloProprietorRegistration) / 1000 ;






}