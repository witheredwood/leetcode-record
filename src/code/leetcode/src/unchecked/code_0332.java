package unchecked;

import java.util.*;

public class code_0332 {
    List<String> res = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        // 存储边
        for (List<String> tmp: tickets) {
            String key = tmp.get(0), value = tmp.get(1);
            if (map.containsKey(key))
                map.get(key).add(value);
            else
                map.put(key, new LinkedList<String>(){{ add(value); }});
        }
        // 排序
        for (String key: map.keySet()) {
            Collections.sort(map.get(key));
        }

        dfs ( "JFK");
        res.add(0, "JFK");

        return res;
    }
    //  深度优先搜索
//    private void dfs(Map<String, List<String>> map, String from, String to) {
    public void dfs(String from) {

        // 无边可走，说明是当前的终点，加入到最终路径中
        if (!map.containsKey(from)) {
//            res.add(0, from);
//            System.out.println("from="+res);
//            stack.push(from);
            return;
        }
        // 有路可走
        List<String> values = map.get(from);
        while (values.size() > 0) {
            String to = values.get(0);
            values.remove(to);
            if (map.get(from).size() == 0) map.remove(from);
            dfs(to);

            // 无路可走
            if (!map.containsKey(to)){
                System.out.println("to="+res);
                res.add(0, to);
            }
        }
    }
}
