package framework_and_drivers.GUI;

import javax.swing.*;
import java.awt.*;

public class AnalysisBar extends JSplitPane {

    private double whitePercent = 0.5;

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
        setDividerLocation((int)(whitePercent*height));
    }

    public void setPercent(double percent) {
        whitePercent = Math.max(0, Math.min(1, percent));
        setDividerLocation(whitePercent);
    }
}