package br.com.mariojp.figureeditor;

import java.awt.*;

public class StyledShape {
    private final Shape shape;
    private final Color fillColor;
    private final Color borderColor;

    public StyledShape(Shape shape, Color fillColor, Color borderColor) {
        this.shape = shape;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public Shape getShape() { return shape; }
    public Color getFillColor() { return fillColor; }
    public Color getBorderColor() { return borderColor; }
}