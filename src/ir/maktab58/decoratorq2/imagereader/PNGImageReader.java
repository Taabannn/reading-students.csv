package ir.maktab58.decoratorq2.imagereader;

import java.io.*;

/**
 * @author Taban Soleymani
 */
public class PNGImageReader implements ImageReader {
    private final static String desFileName = "C:\\Users\\Taban\\Desktop\\maktab\\HW13_Taban\\images\\image.png";

    @Override
    public void convertImage(File sourceFile) {
        try (InputStream input = new FileInputStream(sourceFile)){
            OutputStream output = new FileOutputStream(desFileName);
            byte[] data = new byte[1024];
            int length = input.read(data);
            while (length > 0) {
                output.write(data, 0, length);
                length = input.read(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
