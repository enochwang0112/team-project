package framework_and_drivers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class LocalImageLoader {
    private static final Logger logger = Logger.getLogger(LocalImageLoader.class.getName());

    /**
     * Loads the Image at the URL in memory
     *
     * @param URL  the URL to load the image from
     * @return A scaled version of the image at URL
     */
    public static Image loadLocalImage(String URL){
        BufferedImage defaultReturn = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        try {
            URL imgUrl = LocalImageLoader.class.getResource(URL);
            if (imgUrl == null) {
                System.err.println("Missing image: " + URL);
                return defaultReturn;
            }
            BufferedImage original = ImageIO.read(imgUrl);
            return original;
        } catch (IOException e) {
            logger.warning(e.getMessage());
            return defaultReturn;
        }
    }
}
