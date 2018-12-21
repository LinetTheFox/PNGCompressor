package PNGCompressor.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class Compression {

   public static tableData compression(File origFile, boolean gif, boolean png) {
        if (origFile == null) return null;
        BufferedImage inputIm;
        File newPngFile, newGifFile;
        tableData element = new tableData();
        element.setName(origFile.getName());
        element.setOrigSize(origFile.length());
        try {
            inputIm = ImageIO.read(origFile);
            DecimalFormat dec = new DecimalFormat("###.##");
            if (gif) {
                long gifTimeStart = System.currentTimeMillis();
                ImageIO.write(inputIm, "gif", newGifFile = new File(origFile.getPath() + ".gif"));
                element.setGifTime(System.currentTimeMillis() - gifTimeStart);
                element.setGifSize(newGifFile.length());
                element.setGifEffect(Double.parseDouble(dec.format((100 - ((double) element.getGifSize() / (double) element.getOrigSize()) * 100))));
            }
            if (png) {
                long pngTimeStart = System.currentTimeMillis();
                ImageIO.write(inputIm, "png", newPngFile = new File(origFile.getPath() + ".png"));
                element.setPngTime(System.currentTimeMillis() - pngTimeStart);
                element.setPngSize(newPngFile.length());
                element.setPngEffect(Double.parseDouble(dec.format((100 - ((double) element.getPngSize() / (double) element.getOrigSize()) * 100))));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return element;
    }
}
