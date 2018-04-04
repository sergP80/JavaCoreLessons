package com.javacore.algorithms.interfaces;

@FunctionalInterface
public interface ShapeMovable {
    void move (int dx, int dy);

    static void moveAll(ShapeMovable[] shapes, int dx, int dy)
    {
        for (ShapeMovable mv: shapes)
        {
            mv.move(dx, dy);
        }
    }

    default void moveToOrigin(int origin)
    {
        System.out.println("Move to" + origin);
    }
}
