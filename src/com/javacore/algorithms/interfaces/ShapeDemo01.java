package com.javacore.algorithms.interfaces;

public class ShapeDemo01 {
    public static void main(String[] args) {
        ShapeCalculable sh1 = new Square(100, 200, 350);

        ShapeCalculable sh2 = new Circle(50, -150, 32);
        System.out.println("Printing********");
        System.out.println(sh1);
        System.out.println(sh2);

        System.out.println("Moving********");
        ShapeMovable arr1[] = {(ShapeMovable)sh1, (ShapeMovable)sh2};

        ShapeMovable.moveAll(arr1, -10, -50);
        System.out.println(sh1);
        System.out.println(sh2);
    }
}
