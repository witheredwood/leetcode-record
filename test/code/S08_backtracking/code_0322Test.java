package code.S08_backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 * 示例 2：
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 */
class code_0322Test extends code_0322 {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testFindItinerary() {
        // 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        System.out.println("expected: \n[\"JFK\",\"MUC\",\"LHR\",\"SFO\",\"SJC\"]");
        List<List<java.lang.String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(findItinerary(tickets));
    }

    @Test
    void testFindItinerary2() {
        // 输入：tickets =  [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        // 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
        System.out.println("expected: \n[\"JFK\",\"ATL\",\"JFK\",\"SFO\",\"ATL\",\"SFO\"]");
        List<List<java.lang.String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        System.out.println(findItinerary(tickets));

    }

    @Test
    void testFindItinerary3() {
        // 输入：tickets =  [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        System.out.println("expected: \n[[\"JFK\",\"NRT\",\"JFK\",\"KUL\"]]");
        List<List<java.lang.String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","KUL"));
        tickets.add(Arrays.asList("JFK","NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        System.out.println(findItinerary(tickets));
    }



}
