package enums;

// Enums are by default public, static and final.
// since they are final we cannot create child enums
// type is week
// below are enum constants
// enums can implement interfaces by implementing methods but not extend classes.
// ordinal to know the position, values() method to iterate, value to know the value.

public class Enums {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, saturday, Sunday;

        Week() {
            System.out.println("hehe" + this);
        }
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

//        for(Week day: Week.values()) {
//            System.out.println(day);
//        }
    }
}
