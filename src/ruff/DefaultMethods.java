package ruff;

public class DefaultMethods implements MyInterface{
    @Override
    public void existingMethod() {
        System.out.println("inside existing method");
    }


    public void newDefaultMethod(){
        System.out.println("inside default method");
    }

    public static void main(String[] args){

    }
}

interface MyInterface {
    void existingMethod();

    default void newDefaultMethod() {
        System.out.println("New default method");
    }
}

class Main {
    public static void main(String[] args) {
        MyInterface myClass = new DefaultMethods();
        myClass.existingMethod();
        myClass.newDefaultMethod();
    }
}
