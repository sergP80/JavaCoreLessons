package com.javacore.algorithms.interfaces;

public class Square implements ShapeCalculable, ShapeMovable {
    int x;
    int y;
    int a;

    public Square(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public double area() {
        return a*a;
    }

    @Override
    public double perimeter() {
        return 4*a;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                ", a=" + a +
                ", area=" + area() +
                ", perimeter=" + perimeter() +
                '}';
    }
}
