package ir.maktab58.decoratorq2.imagereader.client;

import ir.maktab58.decoratorq2.imagereader.ImageReader;
import ir.maktab58.decoratorq2.imagereader.JPGImageReader;
import ir.maktab58.decoratorq2.imagereader.decorator.GIFImageReaderDecorator;
import ir.maktab58.decoratorq2.imagereader.decorator.PNGImageReaderDecorator;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) {
        String sourceAddress = "C:\\Users\\Taban\\Desktop\\maktab\\HW13_Taban\\resource\\download.gif";
        User user = new User("Taban", "jpg|png|gif");
        String[] choices = user.getChoices().split("\\|");
        handleUserChoices(sourceAddress, choices);
        System.out.println("Your files have converted successfully.");
    }

    private static void handleUserChoices(String sourceAddress, String[] choices) {
        List<String> listOfChoices = Arrays.stream(choices).toList();
        File fileSource = new File(sourceAddress);
        ImageReader imageReader = new JPGImageReader();
        if (listOfChoices.contains("png"))
            imageReader = new PNGImageReaderDecorator(imageReader);
        if (listOfChoices.contains("gif"))
            imageReader = new GIFImageReaderDecorator(imageReader);
        imageReader.convertImage(fileSource);
    }
}
