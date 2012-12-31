package xeon.tank.util;

import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 12/31/12
 * Time: 8:35 PM
 */
public class ImageHelper {

    public static BufferedImage rotate180( BufferedImage inputImage ) {
        int width = inputImage.getWidth(); //the Width of the original image
        int height = inputImage.getHeight();//the Height of the original image

        BufferedImage returnImage = new BufferedImage( width, height, inputImage.getType()  );

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB(width - x - 1, height - y - 1, inputImage.getRGB(x, y));
            }
        }

        return returnImage;
    }

    public static BufferedImage rotate90ToLeft( BufferedImage inputImage ){
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        BufferedImage returnImage = new BufferedImage( height, width , inputImage.getType()  );

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB(y, width- x - 1, inputImage.getRGB( x, y  )  );
            }
        }
        return returnImage;
    }

    public static BufferedImage rotate90ToRight( BufferedImage inputImage ){
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        BufferedImage returnImage = new BufferedImage( height, width , inputImage.getType()  );

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB( height - y -1, x, inputImage.getRGB( x, y  )  );
            }
        }
        return returnImage;
    }
}
