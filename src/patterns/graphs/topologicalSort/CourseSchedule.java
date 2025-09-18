package patterns.graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++) list.add(new ArrayList<>());
        for(int[] arr: prerequisites) {
            list.get(arr[0]).add(arr[1]);
        }
        int[] inDegree = new int[numCourses];
        for(int i= 0;i<numCourses;i++) {
            for(int num : list.get(i)) {
                inDegree[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0;i<numCourses;i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for(int it: list.get(node)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        if(topo.size() == numCourses) return true;
        return false;
    }
}
