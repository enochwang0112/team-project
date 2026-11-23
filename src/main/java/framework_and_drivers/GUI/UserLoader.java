package framework_and_drivers.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class UserLoader extends JPanel {
    private final JLabel userNotFoundWarning;
    private final JTextField userInput;

    public UserLoader(Consumer<UserLoader> callback){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45, 52, 54));

        JLabel usernameInfo = new JLabel("Chess.com Username");
        usernameInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameInfo.setFont(new Font("SansSerif", Font.BOLD, 13));
        usernameInfo.setForeground(Color.WHITE);


        // Username input bar
        userInput = new JTextField();
        userInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        userInput.setPreferredSize(new Dimension(200, 32));
        userInput.setBackground(new Color(65, 75, 78));
        userInput.setForeground(Color.WHITE);
        userInput.setCaretColor(Color.WHITE);
        userInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(90, 100, 103)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        userInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        // No user found warning
        userNotFoundWarning = new JLabel("User not found");
        userNotFoundWarning.setForeground(Color.red);
        userNotFoundWarning.setAlignmentX(Component.LEFT_ALIGNMENT);
        userNotFoundWarning.setVisible(false);
        userNotFoundWarning.setBackground(new Color(45, 52, 54));

        JButton enterUser = new JButton("Load Archives");
        enterUser.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterUser.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        add(usernameInfo);
        add(Box.createVerticalStrut(8));
        add(userInput);
        add(Box.createVerticalStrut(10));
        add(enterUser);
        add(userNotFoundWarning);

        enterUser.addActionListener(e -> {
            callback.accept(this);
        });
    }

    public String getUsername(){
        return userInput.getText();
    }

    public void showNoUserFoundWarning(){
        userNotFoundWarning.setVisible(true);
    }

    public void hideNoUserFoundWarning(){
        userNotFoundWarning.setVisible(false);
    }
}
