package ir.maktab58.decoratorq2.imagereader.decorator;

import ir.maktab58.decoratorq2.imagereader.GIFImageReader;
import ir.maktab58.decoratorq2.imagereader.ImageReader;

import java.io.File;

/**
 * @author Taban Soleymani
 */
public class GIFImageReaderDecorator extends ImageReaderBaseDecorator {
    GIFImageReader gifImageReader = new GIFImageReader();

    public GIFImageReaderDecorator(ImageReader imageReader) {
        super(imageReader);
    }

    @Override
    public void convertImage(File sourceFile) {
        super.convertImage(sourceFile);
        gifImageReader.convertImage(sourceFile);
    }
}
