package maps;

public class Main {
    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();
        map.put("mango", "king of frutis");
        map.put("apple", "good for nothing");
        map.put("Litchi", "sour light green fruit");

        System.out.println(map.get("mango"));
    }
}
