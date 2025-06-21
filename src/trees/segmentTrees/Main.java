package trees.segmentTrees;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        SegmentTreeImplementation segment = new SegmentTreeImplementation(arr);
        System.out.println(segment.query(2,4));
        segment.update(1,3);
        segment.display();
        System.out.println(segment.query(0,5));
    }
}
