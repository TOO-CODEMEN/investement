package com.too_codemen.application.pdf;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

public class Convertor {

    @SneakyThrows
    public void convertor() throws FileNotFoundException {
        Document doc = new Document();

        Thread.sleep(1000);
// Каталог изображений
        File imageDir = new File("C:\\Users\\Администратор\\IdeaProjects\\investement\\src\\main\\resources\\outputImages");

        // Получить список файлов
        File[] files = imageDir.listFiles();

// Определить компаратор для сортировки по имени
        Comparator<File> comparator = new Comparator<File>() {
            public int compare(File f1, File f2) {
                return f1.getName().compareTo(f2.getName());
            }
        };

// Отсортировать файлы по имени
        Arrays.sort(files, comparator);

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
