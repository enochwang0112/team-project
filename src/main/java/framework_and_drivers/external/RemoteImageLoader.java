package framework_and_drivers.external;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
public class RemoteImageLoader {
    private static final Logger logger = Logger.getLogger(framework_and_drivers.external.RemoteImageLoader.class.getName());

    /**
     * Loads the Image at the online URL. Returns null if no image was found.
     *
     * @param URL  the URL to load the image from
     * @return A scaled version of the image at URL
     */
    public static Image loadRemoteImage(String URL){
        try {
            URL url = URI.create(URL).toURL();
            BufferedImage image = ImageIO.read(url);

            if (image == null) {
                System.err.println("Missing image: " + URL);
                return null;
            }

            return image;

        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }
}
