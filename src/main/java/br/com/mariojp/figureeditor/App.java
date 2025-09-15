package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor - Abstract Factory");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            final ShapeFactory blueFactory = new BlueFactory();
            final ShapeFactory redFactory = new RedFactory();
            
            DrawingPanel panel = new DrawingPanel(blueFactory);

            JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JToggleButton circleButton = new JToggleButton("Circle", true);
            JToggleButton rectButton = new JToggleButton("Rectangle");
            ButtonGroup shapeGroup = new ButtonGroup();
            shapeGroup.add(circleButton);
            shapeGroup.add(rectButton);

            JToggleButton blueButton = new JToggleButton("Blue Style", true);
            JToggleButton redButton = new JToggleButton("Red Style");
            ButtonGroup styleGroup = new ButtonGroup();
            styleGroup.add(blueButton);
            styleGroup.add(redButton);
            
            JButton clearButton = new JButton("Clear");

            controlPanel.add(new JLabel("Shape:"));
            controlPanel.add(circleButton);
            controlPanel.add(rectButton);
            controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
            controlPanel.add(new JLabel("Style:"));
            controlPanel.add(blueButton);
            controlPanel.add(redButton);
            controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
            controlPanel.add(clearButton);

            circleButton.addActionListener(e -> panel.setCurrentShapeType(DrawingPanel.ShapeType.CIRCLE));
            rectButton.addActionListener(e -> panel.setCurrentShapeType(DrawingPanel.ShapeType.RECTANGLE));
            
            blueButton.addActionListener(e -> panel.setFactory(blueFactory));
            redButton.addActionListener(e -> panel.setFactory(redFactory));
            
            clearButton.addActionListener(e -> panel.clear());
            
            frame.setLayout(new BorderLayout());
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}