package ru.geekbrains.level3.lession4;

public class Triangle {
    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double squareOfTriangle (){
        if( !(a<=0 | b<=0 | c<=0) ){
            if( a+b>c & b+c>a & c+a>b ){
                double p = ((double)a + b + c) / 2;
                double square = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                return square;
            }
                System.out.println("wrong triangle sides size (triangle not closed)");
                return 0;
        }
        System.out.println("wrong triangle size (zero or less side size)");
        return 0;
    }

}
