package java15.sealedClasses;

sealed class Bike extends Vehicle permits SuperBike {
    public void show() {
        System.out.println("This is a Bike");
    }
}
