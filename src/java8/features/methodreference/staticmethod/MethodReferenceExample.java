package java8.features.methodreference.staticmethod;

public class MethodReferenceExample {
    public static void sayHello() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        Runnable r = MethodReferenceExample::sayHello;
        new Thread(r).start();
    }
}

