package ru.geekbrains.level3.lession4;

public class Triangle {
    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangleExist() {
        if (a + b > c & b + c > a & c + a > b) {
            return true;
        }
            System.out.println("triangle doesn't exist");
            return false;
    }

    public double squareOfTriangle (){
        double p = ((double)a + b + c) / 2;
        double square = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return square;
    }


}
