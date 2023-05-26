package com.too_codemen.application.pdf;
import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;



public class AddTextToPdf {



    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        try {

            Draw draw = new Draw();
            BufferedImage image3 = ImageIO.read(new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\inputImages\\3.jpg")); // загрузка исходного изображения
            BufferedImage image4 = ImageIO.read(new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\inputImages\\4.jpg")); // загрузка исходного изображения


            //3, отрасль
            draw.Draw("Пищевая промышленность", 662, 365, image3);
            //3, тип организации
            draw.Draw("Индивидуальный предприниматель", 662, 505, image3);
            //3, численность сотрудников
            draw.Draw("140", 662, 644, image3);
            //3, регион
            draw.Draw("ВАО", 662, 769, image3);
            //3, общие расходы
            draw.Draw("1000 млн.руб", 662, 983, image3);
            //3, персонал
            draw.Draw("300 млн.руб", 662, 1187, image3);
            //3, аренда недвижимости
            draw.Draw("300 млн.руб", 662, 1293, image3);
            //3, налоги
            draw.Draw("300 млн.руб", 662, 1398, image3);
            //3, услуги
            draw.Draw("100 млн.руб", 662, 1496, image3);

            //расходы на персонал
            draw.Draw("100 млн.руб", 700, 1025, image4);
            //количество людей
            draw.Draw("10000", 700, 1172, image4);
            //Пенсионное страхование
            draw.Draw("20 млн.руб", 700, 1297, image4);
            //Медицинское страхование
            draw.Draw("20 млн.руб", 700, 1431, image4);


            // запись результирующего изображения в файл
            ImageIO.write(image3, "jpg", new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\outputImages\\output3.png"));
            ImageIO.write(image4, "jpg", new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\outputImages\\output4.png"));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


        Thread.sleep(1000);

        // Создать новый документ
        Document doc = new Document();

// Каталог изображений
        File imageDir = new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\outputImages");

        for(File image: imageDir.listFiles()) {
            // Добавить страницу в коллекцию страниц документа
            Page page = doc.getPages().add();

            // Загрузить изображение в поток
            java.io.FileInputStream imageStream = new java.io.FileInputStream(new java.io.File(image.getPath()));

            // Установите поля, чтобы изображение соответствовало размеру и т.д
            page.getPageInfo().getMargin().setBottom(0);
            page.getPageInfo().getMargin().setTop(0);
            page.getPageInfo().getMargin().setLeft(0);
            page.getPageInfo().getMargin().setRight(0);
            page.setCropBox(new com.aspose.pdf.Rectangle(0, 0, 1240, 1755));

            // Создайте объект изображения
            Image image1 = new Image();

            // Добавьте изображение в коллекцию абзацев раздела
            page.getParagraphs().add(image1);

            // Установите поток файла изображения
            image1.setImageStream(imageStream);
        }

// Сохраните полученный файл PDF
        doc.save("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\results.pdf");


    }



}
