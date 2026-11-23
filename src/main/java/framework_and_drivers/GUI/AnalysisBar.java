package framework_and_drivers.GUI;

import javax.swing.*;
import java.awt.*;

public class AnalysisBar extends JSplitPane {

    public AnalysisBar(int width, int height) {
        super(JSplitPane.VERTICAL_SPLIT);

        setPreferredSize(new Dimension(width, height));

        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);

        setTopComponent(blackPanel);
        setBottomComponent(whitePanel);
        setDividerSize(0);
        setEnabled(false);
        setDividerLocation((int)(0.5*height));
    }

    /**
     * Sets the split between black and white represented as a double between 0 and 1.
     * @param percent Percentage of black in the bar.
     */
    public void setPercent(double percent) {
        double split = Math.max(0, Math.min(1, percent));
        setDividerLocation(split);
    }
}