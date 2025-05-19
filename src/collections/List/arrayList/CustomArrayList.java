package collections.List.arrayList;

public class CustomArrayList<T> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 10;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if(this.isFull()) {
            resize();
        }
        data[size++]  = num;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void resize() {
        Object[] temp = new Object[data.length * 2];
        for(int i=0; i< temp.length;i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove() {
        T removed = (T)data[--size];
        return removed;
    }

    public static void main(String[] args) {

    }
}
