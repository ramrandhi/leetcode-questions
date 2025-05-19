package java15.sealedClasses;

// final → No further subclassing.
// sealed → Continue restricting subclassing.
// non-sealed → Remove restrictions (open for subclassing).

sealed class Vehicle permits Bike, Car{
    public void show() {
        System.out.println("This is a vehicle");
    }
}
