package java8.features.methodreference.instancemethod;

public class MethodReferenceExample {
    public void printMessage() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        MethodReferenceExample example = new MethodReferenceExample();
        Runnable r = example::printMessage;
        new Thread(r).start();
    }
}

