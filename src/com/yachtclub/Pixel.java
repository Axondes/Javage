package com.yachtclub;

public class Pixel {

    private int r;
    private int g;
    private int b;
    private int a;

    //Constructor

    public Pixel(int r, int g, int b, int a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    //Gets RGBA values

    public int getR(){
        return r;
    }

    public int getG(){
        return g;
    }

    public int getB(){
        return b;
    }

    public int getA(){
        return a;
    }

    //Compares the differences in colors of two pixels

    public int compareTo(Pixel other){
        return Math.abs(this.getR() - other.getR()) + Math.abs(this.getG() - other.getG()) + Math.abs(this.getB() - other.getB());
    }

    //Modifies pixels in certain ways

    public void transform(String method){
        switch (method) {
            case "invert":
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

            case "bw":
                int temp = (r + g + b) / 3;
                r = temp;
                g = temp;
                b = temp;
        }
    }
}
