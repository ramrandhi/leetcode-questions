package stacks.internal_implementations;

public class CustomStackFixedSize {
    private int[] size;
    private static int DEFAULT_SIZE = 10;

    private int pivot = -1;

    public CustomStackFixedSize() {
        this(DEFAULT_SIZE);
    }
    public CustomStackFixedSize(int data) {
        this.size = new int[data];
    }




}
