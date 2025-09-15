package br.com.mariojp.figureeditor;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class RedFactory implements ShapeFactory {
    private static final Color FILL_COLOR = new Color(220, 20, 60);
    private static final Color BORDER_COLOR = new Color(0, 0, 0, 70);

    @Override
    public StyledShape createCircle(Point center, int size) {
        Shape circle = new Ellipse2D.Double(center.x - size / 2.0, center.y - size / 2.0, size, size);
        return new StyledShape(circle, FILL_COLOR, BORDER_COLOR);
    }

    @Override
    public StyledShape createRectangle(Point origin, int size) {
        Shape rect = new Rectangle2D.Double(origin.x - size / 2.0, origin.y - size / 2.0, size, size);
        return new StyledShape(rect, FILL_COLOR, BORDER_COLOR);
    }
}