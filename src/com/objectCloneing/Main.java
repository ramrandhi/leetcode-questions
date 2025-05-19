package com.objectCloneing;

public class Main {
    public static void main(String[] args) {
        Human obj1 = new Human(25, "ram");
//    Human obj2 = new Huma(obj1);      takes more time to clone from obj1
        Human obj2 = null;
        try {
            obj2 = (Human) obj1.clone();
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(obj2);
        }
    }
}
