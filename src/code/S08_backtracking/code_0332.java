package code.S08_backtracking;

import java.util.*;

/**
 * 332.重新安排行程
 * <p>
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * <p>
 * 示例 1：
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 * 示例 2：
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0332 {
    /**
     * 回溯
     *
     * @param tickets 航线列表
     * @return 行程组合, 字典排序最小
     */
    public List<String> findItinerary31(List<List<String>> tickets) {
        // 排序
        Collections.sort(tickets, (a, b) -> {
            if (!a.get(0).equals(b.get(0))) return a.get(0).compareTo(b.get(0)) < 0 ? -1 : 1;
            return a.get(1).compareTo(b.get(1)) < 0 ? -1 : 1;
        });
        // 存储机票
        Map<String, List<String>> map = new HashMap<>();      // 存放以 from 为起点的所有机票
        Map<String, Integer> counts = new HashMap<>();  // 机票个数机票可以与有重复的
        int n = tickets.size();  // 机票个数
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(ticket.get(0))) {
                map.put(from, new LinkedList<>());
            }
            map.get(from).add(to);
            String cur = from + " " + to;
            if (!counts.containsKey(cur)) counts.put(cur, 1);
            else counts.replace(cur, counts.get(cur) + 1);
        }

        List<String> path = new LinkedList<>();
        path.add("JFK");
        List<String> result = backtracking("JFK", n, map, counts, path);
        
        if (result == null || result.size() == 1) return new LinkedList<>();
        return result;
    }

    private List<String> backtracking(String from, int n, Map<String, List<String>> map, Map<String, Integer> counts, List<String> path) {
        if (path.size() > n) {
            return path;
        }
        if (!map.containsKey(from)) return null;
        for (int i = 0; i < map.get(from).size(); i++) {
            String to = map.get(from).get(i);
            String ticket = from + " " + to;
            if (!counts.containsKey(ticket) || counts.get(ticket) == 0) continue;
            counts.replace(ticket, counts.get(ticket) - 1);
            path.add(to);
            List<String> res = backtracking(to, n, map, counts, path);
            if (res != null) return res;
            path.remove(path.size() - 1);
            counts.replace(ticket, counts.get(ticket) + 1);
        }
        return null;
    }

    /**
     * 回溯
     *
     * @param tickets 航线列表
     * @return 行程组合, 字典排序最小
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        /** 存储符合条件的结果的集合 */
        List<String> res = new LinkedList<>();
        /** 存储符合条件的结果的集合 */
        LinkedList<String> path = new LinkedList<>();
        /** 存储每个出发地对应的所有目的地 */
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                List<String> list = new LinkedList<>();
                list.add(to);
                map.put(from, list);
            }
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        System.out.println("map => " + map.toString());
        path.add("JFK");
        backtracking(tickets, "JFK", map, res, path);
        return res;
    }

    /**
     * @param tickets 航线列表
     * @param from    出发地
     * @param map     存储每个出发地对应的所有目的地
     * @param res     存储符合条件的结果的集合
     * @param path    存储符合条件的结果的集合
     */
    public void backtracking(List<List<String>> tickets, String from, Map<String, List<String>> map, List<String> res, LinkedList<String> path) {
        if (res.size() >= 1) return;
        if (path.size() >= tickets.size() + 1) {
            res.addAll(path);
            return;
        }
        // 找到所有可以到达的目的地
        if (!map.containsKey(from) || map.get(from).size() <= 0) return;
        List<String> toList = map.get(from);
        for (int i = 0; i < toList.size(); i++) {
            String to = toList.get(i);
            path.add(to);
            map.get(from).remove(to);
            backtracking(tickets, to, map, res, path);
            path.removeLast();
            map.get(from).add(i, to);
        }
    }
}
