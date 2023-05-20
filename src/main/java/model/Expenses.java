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

String Industry;

int Headcount;

//Location Of Production
String ProductionArea;

//Estimated land area production
int ProductionSquare; //square meters

//Planned area of capital construction
int PlannedAreaOfConstruction; //square meters

String Equipment;

String TypeOfBuilding;

int SquareOfBuilding;

int AccountingServices;

int Patent;

int Others;
}
