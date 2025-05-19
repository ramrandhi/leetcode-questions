package oop.constructorsAccess;

public class BoxWeight extends Box{
    int weight;

    public BoxWeight() {
        super();
        this.weight = 1;
    }

    public BoxWeight(int l, int b, int h, int weight) {
        super(l,b,h);
        this.weight = weight;
    }
}
