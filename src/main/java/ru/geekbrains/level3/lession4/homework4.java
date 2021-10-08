package ru.geekbrains.level3.lession4;

public class homework4 {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3, 4, 5);

        if (triangle.isTriangleExist()) {
            System.out.println("Triangle's S = " + triangle.squareOfTriangle());
        }
    }
}