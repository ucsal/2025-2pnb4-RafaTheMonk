package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;

    private final List<StyledShape> styledShapes = new ArrayList<>();
    
    private ShapeFactory currentFactory;

    private ShapeType currentShapeType = ShapeType.CIRCLE;
    
    enum ShapeType { CIRCLE, RECTANGLE }

    DrawingPanel(ShapeFactory initialFactory) {
        this.currentFactory = initialFactory;
        
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    StyledShape newShape;
                    if (currentShapeType == ShapeType.CIRCLE) {
                        newShape = currentFactory.createCircle(e.getPoint(), DEFAULT_SIZE);
                    } else {
                        newShape = currentFactory.createRectangle(e.getPoint(), DEFAULT_SIZE);
                    }
                    styledShapes.add(newShape);
                    repaint();
                }
            }
        };
        addMouseListener(mouse);
    }
    
    public void setFactory(ShapeFactory factory) {
        this.currentFactory = factory;
    }

    public void setCurrentShapeType(ShapeType shapeType) {
        this.currentShapeType = shapeType;
    }

    void clear() {
        styledShapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (StyledShape s : styledShapes) {
            g2.setColor(s.getFillColor());
            g2.fill(s.getShape());
            g2.setColor(s.getBorderColor());
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(s.getShape());
        }

        g2.dispose();
    }
}