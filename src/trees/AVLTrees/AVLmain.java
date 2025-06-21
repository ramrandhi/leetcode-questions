package trees.AVLTrees;

public class AVLmain {
    public static void main(String[] args) {
        AVLTreeImplementation avl = new AVLTreeImplementation();
        for(int i=0; i<100;i++) {
            avl.insert(i);
        }
        System.out.println(avl.height());
    }
}
