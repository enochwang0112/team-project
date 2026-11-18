package framework_and_drivers.GUI;

import utils.ImageHelper;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class PlayerCard extends JPanel{
    private final JLabel photoCard;
    private final JLabel usernameDisplay;
    private final JLabel ratingDisplay;
    private static final String defaultImage = "/defaultavatar.png";

    public PlayerCard(int size){
        photoCard = new JLabel();
        usernameDisplay = new JLabel("No user loaded");
        ratingDisplay = new JLabel("Rating: 0");

        JPanel textBox = new JPanel();

        setPhoto(new ImageIcon(ImageHelper.getScaledImage(-1, size, defaultImage)));

        //TODO: Make this look nicer
        setBackground(new Color(100,100,100));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        textBox.setLayout(new BoxLayout(textBox, BoxLayout.Y_AXIS));
        textBox.setBackground(new Color(100, 100, 100));

        textBox.add(usernameDisplay, BorderLayout.NORTH);
        textBox.add(ratingDisplay, BorderLayout.SOUTH);

        add(photoCard, BorderLayout.WEST);
        add(textBox);
    }

    public void setUsername(String name){
        usernameDisplay.setText(name);
    }

    public void setRating(int rating){
        ratingDisplay.setText("Rating: " + rating);
    }

    public void setPhoto(ImageIcon photo){
        photoCard.setIcon(photo);
    }
}
