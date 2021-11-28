package ir.maktab58.decoratorq2.imagereader.decorator;

import ir.maktab58.decoratorq2.imagereader.ImageReader;

import java.io.File;

/**
 * @author Taban Soleymani
 */
public class ImageReaderBaseDecorator implements ImageReader {
    private ImageReader imageReader;

    public ImageReaderBaseDecorator(ImageReader imageReader) {
        this.imageReader = imageReader;
    }

    @Override
    public void convertImage(File sourceFile) {
        imageReader.convertImage(sourceFile);
    }
}
