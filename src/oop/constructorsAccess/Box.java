package oop.constructorsAccess;

public class Box {
    int l;
    int b;
    int h;
    public Box(){
        this.h = 1;
        this.b = 1;
        this.l = 1;
    }

    public Box(int h, int b, int l) {
        this.h = h;
        this.b = b;
        this.l = l;
    }
}
