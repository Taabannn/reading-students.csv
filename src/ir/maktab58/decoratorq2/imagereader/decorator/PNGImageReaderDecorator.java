package ir.maktab58.decoratorq2.imagereader.decorator;

import ir.maktab58.decoratorq2.imagereader.ImageReader;
import ir.maktab58.decoratorq2.imagereader.PNGImageReader;

import java.io.File;

/**
 * @author Taban Soleymani
 */
public class PNGImageReaderDecorator extends ImageReaderBaseDecorator {
    PNGImageReader pngImageReader = new PNGImageReader();

    public PNGImageReaderDecorator(ImageReader imageReader) {
        super(imageReader);
    }

    @Override
    public void convertImage(File sourceFile) {
        super.convertImage(sourceFile);
        pngImageReader.convertImage(sourceFile);
    }
}
