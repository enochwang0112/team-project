package framework_and_drivers.GUI;

import framework_and_drivers.LocalImageLoader;

import javax.swing.*;
import java.awt.*;


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

        setPhoto(new ImageIcon(LocalImageLoader
                .loadLocalImage(defaultImage)
                .getScaledInstance(-1, size, Image.SCALE_DEFAULT)));

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

    /**
     * Sets the player's username.
     * @param name Username to set.
     */
    public void setUsername(String name){ usernameDisplay.setText(name); }

    /**
     * Sets the player's rating.
     * @param rating Rating to set.
     */
    public void setRating(int rating){ ratingDisplay.setText("Rating: " + rating); }

    /**
     * Sets the player's profile picture.
     * @param photo Profile picture to set.
     */
    public void setPhoto(ImageIcon photo){ photoCard.setIcon(photo); }
}
