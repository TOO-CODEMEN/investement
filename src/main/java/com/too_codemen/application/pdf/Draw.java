package com.too_codemen.application.pdf;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Draw {

    public void Draw(String text, int x, int y, BufferedImage image){
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.BOLD, 23));

        g2d.drawString(text, x, y);
    }


}
