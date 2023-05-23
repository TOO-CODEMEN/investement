package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expenses {

    int INN; //ИНН

    String industry;

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

    int patent;

    int others;
}
