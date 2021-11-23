package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            System.out.println("queue="+queue);
            int top = queue.poll();
            // 加入能拿到的钥匙
            System.out.println("room[top]="+rooms.get(top));
            for (int t: rooms.get(top)) {
                if (!visited[t])    queue.add(t);
            }
            visited[top] = true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
