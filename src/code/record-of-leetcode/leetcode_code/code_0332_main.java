package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0332_main {
    public static List<List<String>> tickets = new LinkedList<>();
    public static void main(String[] args) {
        // [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        // ["JFK", "MUC", "LHR", "SFO", "SJC"]
        addData("MUC", "LHR");
        addData("JFK", "MUC");
        addData("SFO", "SJC");
        addData("LHR", "SFO");

        // ["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]
        // ["JFK","ATL","JFK","SFO","ATL","SFO"]
//        addData("JFK", "SFO");
//        addData("JFK", "ATL");
//        addData("SFO", "ATL");
//        addData("ATL", "JFK");
//        addData("ATL", "SFO");

        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        // ["JFK","NRT","JFK","KUL"]
//        addData("JFK", "KUL");
//        addData("JFK", "NRT");
//        addData("NRT", "JFK");

        // [["JFK","AAA"],["AAA","JFK"],["JFK","BBB"],["JFK","CCC"],["CCC","JFK"]]
        // ["JFK","AAA","JFK","CCC","JFK","BBB"]
//        addData("JFK", "AAA");
//        addData("AAA", "JFK");
//        addData("JFK", "BBB");
//        addData("JFK", "CCC");
//        addData("CCC", "JFK");

        code_0332 one = new code_0332();
        List<String> res = one.findItinerary(tickets);
        for (String t: res) {
            System.out.print(t +" ");
        }
        System.out.println();
    }

    public static void addData(String from, String to) {
        List<String> list = new LinkedList<String>(){{
            add(from);
            add(to);
        }};
        tickets.add(list);
    }
}
