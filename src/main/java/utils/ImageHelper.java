package utils;

import framework_and_drivers.GUI.ChessBoard;
import framework_and_drivers.GUI.PlayerCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class ImageHelper {
    private static final Logger logger = Logger.getLogger(ImageHelper.class.getName());

    /**
     * Loads the Image at the URL then creates a scaled version of that Image. A new Image object is returned which will render the image at the specified width and height by default.
     * If either width or height is a negative number then a value is substituted to maintain the aspect ratio of the original image dimensions. If both width and height are negative, then the original image dimensions are used.
     * @param width  The width to which to scale the image.
     * @param height The height to which to scale the image.
     * @param URL    The URL from which to load the image.
     * @return A scaled version of the image at URL
     */
    public static Image getScaledImage(int width, int height, String URL){
        BufferedImage defaultReturn = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        try {
            URL imgUrl = ChessBoard.class.getResource(URL);
            if (imgUrl == null) {
                System.err.println("Missing image: " + URL);
                return defaultReturn;
            }
            BufferedImage original = ImageIO.read(imgUrl);
            Image scaled = original.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            return scaled;
        } catch (IOException e) {
            logger.warning(e.getMessage());
            return defaultReturn;
        }
    }
}
