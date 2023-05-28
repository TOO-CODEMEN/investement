package com.too_codemen.application.pdf;
import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.too_codemen.application.calculations.Results;
import com.too_codemen.application.model.Expenses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;



public class AddTextToPdf {



    public void addTextToPdf(Results results, Expenses expenses) {
        try {

            Draw draw = new Draw();
            BufferedImage image3 = ImageIO.read(new File("/imagesInput/3.jpg")); // загрузка исходного изображения
            BufferedImage image4 = ImageIO.read(new File("/imagesInput/4.jpg")); // загрузка исходного изображения


            String industryStr = expenses.getIndustry();
            String typeOfOrganizationStr = expenses.getTypeOfOrganization();
            String headCountStr = Integer.toString(expenses.getHeadcount());
            String productionAreaStr = expenses.getProductionArea();

            String resultStr = Double.toString(results.getResult()) + " млн.руб";
            String staffStr = Double.toString(results.getStaff()) + " млн.руб";
            String realEstateStr = Double.toString(results.getRealEstate()) + " млн.руб";
            String taxesStr = Double.toString(results.getTaxes()) + " млн.руб";
            String servicesStr = Double.toString(results.getServices()) + " млн.руб";
            String sumPensionStr = Double.toString(results.getSumPension()) + " млн.руб";
            String sumMedicineStr = Double.toString(results.getSumMedicine()) + " млн.руб";

                    //Expenses
            //3, отрасль
            draw.Draw(industryStr, 662, 365, image3);
            //3, тип организации
            draw.Draw(typeOfOrganizationStr, 662, 505, image3);
            //3, численность сотрудников
            draw.Draw(headCountStr, 662, 644, image3);
            //3, регион
            draw.Draw(productionAreaStr, 662, 769, image3);
            //Expenses
            //3, общие расходы
            draw.Draw(resultStr, 662, 983, image3);
            //3, персонал
            draw.Draw(staffStr, 662, 1187, image3);
            //3, аренда недвижимости
            draw.Draw(realEstateStr, 662, 1293, image3);
            //3, налоги
            draw.Draw(taxesStr, 662, 1398, image3);
            //3, услуги
            draw.Draw(servicesStr, 662, 1496, image3);

            //расходы на персонал
            draw.Draw(staffStr, 700, 1025, image4);
            //количество людей
            draw.Draw(headCountStr, 700, 1172, image4);
            //Пенсионное страхование
            draw.Draw(sumPensionStr, 700, 1297, image4);
            //Медицинское страхование
            draw.Draw(sumMedicineStr, 700, 1431, image4);


            // запись результирующего изображения в файл
            ImageIO.write(image3, "jpg", new File("/imagesOutput/output3.png"));
            ImageIO.write(image4, "jpg", new File("/imagesOutput/output4.png"));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }




    }



}
