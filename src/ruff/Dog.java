package ruff;

public class Dog {
    String name;
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        changeName(dog);
        System.out.println(dog.name);
    }

    static void changeName(Dog d) {
        d.name = "Charlie";       // ✅ Modifies original
        d = new Dog();            // ❌ New object, does not affect original
        d.name = "Rocky";
    }
}
