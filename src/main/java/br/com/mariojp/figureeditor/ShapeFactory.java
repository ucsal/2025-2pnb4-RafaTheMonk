package br.com.mariojp.figureeditor;

import java.awt.Point;

public interface ShapeFactory {
    StyledShape createCircle(Point center, int size);
    StyledShape createRectangle(Point origin, int size);
}