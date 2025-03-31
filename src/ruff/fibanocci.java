package ruff;

public class fibanocci {

    public static void main(String [] args){
        System.out.println(fibanocci(6));
    }

    public static int fibanocci(int n){
        if (n <= 1) {
            return n;
        }
        return fibanocci(n-1) + fibanocci(n-2);
    }
}
