package code.S07_tree;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列beginWord -> s1-> s2-> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在wordList中。
 * sk== endWord
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 提示：
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0127 {
    Map<String, List<String>> adjList = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    int num = Integer.MAX_VALUE;

    /**
     * 将单词列表中的关系构造成图。使用广度优先搜索解决。
     * time: O(n^2*m);      space: O(n^2);      m 是字符串的长度
     *
     * @param beginWord 起始节点
     * @param endWord   结束节点
     * @param wordList  单词列表
     * @return 转换序列的长度
     */
    public int ladderLength31(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(0, beginWord);
        int endIndex = wordList.indexOf(endWord);
        // 单词对应的转换表
        List<Integer>[] conversion = new List[wordList.size()];
        // 初始化转换表
        init(wordList, conversion);
        for (int i = 0; i < conversion.length; i++) {
            System.out.print(conversion[i] + " ");
        }
        // 广度优先遍历
        boolean[] visited = new boolean[conversion.length];
        return bfs(conversion, 0, endIndex, visited);
    }

    /**
     * 广度优先遍历。先访问顶点，标记后入队。
     * time: O(n);      space: O(n^2)
     */
    private int bfs(List<Integer>[] conversion, int index, int endIndex, boolean[] visited) {
        // 访问顶点
        int len = 1;
        visited[index] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(index);
        int last = queue.getLast();
        while (!queue.isEmpty() && endIndex != queue.peek()) {
            int cur = queue.poll();
            if (conversion[cur] != null) return 0;
            for (int i = 0; i < conversion[cur].size(); i++) {
                int adjIndex = conversion[cur].get(i);  // 邻接点的下标
                // 若邻接点未访问，则访问该顶点
                if (!visited[adjIndex]) {
                    visited[adjIndex] = true;
                    queue.offer(adjIndex);
                }
            }
            if (cur == last) {
                len++;
                if (!queue.isEmpty()) last = queue.getLast();
            }
        }
        return queue.isEmpty() ? 0 : len;
    }

    /**
     * 初始化图的邻接表
     * time: O(n^2*m);      space: O(n);          m 是字符串的长度
     */
    private void init(List<String> wordList, List<Integer>[] conversion) {
        for (int i = 0; i < wordList.size(); i++) {
            String first = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String second = wordList.get(j);
                // 判断两个字符串是否相差一个字符
                int count = 0;
                for (int k = 0; k < first.length(); k++) {
                    if (first.charAt(k) != second.charAt(k)) {
                        count++;
                        if (count > 1) break;
                    }
                }
                // 两个字符串相差一个字符
                if (count == 1) {
                    if (conversion[i] == null) conversion[i] = new LinkedList<>();
                    conversion[i].add(j);
                    if (conversion[j] == null) conversion[j] = new LinkedList<>();
                    conversion[j].add(i);
                }
            }
        }
    }

    /**
     * 将单词列表中的关系构造成图。使用广度优先搜索解决。
     *
     * @param beginWord 起始节点
     * @param endWord   结束节点
     * @param wordList  单词列表
     * @return 转换序列的长度
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        adjList = buildLists(wordList);
        for (String word : wordList) {
            visited.put(word, false);
        }
        num = BFS(beginWord, endWord);
        return num;
    }

    /**
     * 广度优先搜索
     *
     * @param beginWord 起始节点
     * @param endWord   结束节点
     * @return 转换序列的长度
     */
    private int BFS(String beginWord, String endWord) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        String last = beginWord;
        int layer = 1;
        while (!queue.isEmpty()) {
            System.out.println(layer + " " + last + " " + queue);
            String cur = queue.poll();  // 出队
            // 加入邻接点
            for (String word : adjList.get(cur)) {
                if (!visited.get(word)) {
                    visited.replace(word, true);  // 标记为已访问
                    queue.offer(word);   // 入队
                }
            }
            // 访问该节点
            if (cur.equals(endWord)) {
                return layer;
            }
            if (last.equals(cur)) {
                layer++;
                if (!queue.isEmpty()) last = queue.getLast();
            }
        }
        return 0;
    }

    /**
     * 将单词列表中的关系构造成图。使用深度优先搜索进行遍历。
     * 时间超时
     *
     * @param beginWord 起始节点
     * @param endWord   结束节点
     * @param wordList  单词列表
     * @return 转换序列的长度
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        adjList = buildLists(wordList);
        for (String word : wordList) {
            visited.put(word, false);
        }
        DFS(beginWord, endWord, 1);
        return (num == Integer.MAX_VALUE ? 0 : num);
    }

    /**
     * 深度优先搜索。思想和通过回溯进行穷举一样
     *
     * @param cur     当前访问节点
     * @param endWord 结束节点
     * @param layer   第几层
     */
    private void DFS(String cur, String endWord, int layer) {
        System.out.println(cur + " " + layer + " " + num);
        if (layer >= num) return;
        if (cur.equals(endWord)) {
            num = layer;
            return;
        }
        visited.replace(cur, true);
        layer++;
        for (String word : adjList.get(cur)) {
            if (!visited.get(word)) {
                DFS(word, endWord, layer);
            }
        }
    }


    /**
     * 方案：使用回溯来解决，本题中同一路径上没有相同节点（访问过的节点不再访问）
     * 时间超时
     *
     * @param beginWord 起始节点
     * @param endWord   结束节点
     * @param wordList  单词列表
     * @return 转换序列的长度
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        // build the list for each word
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        adjList = buildLists(wordList);
        Map<String, Boolean> visited = new HashMap<>();
        for (String word : wordList) {
            visited.put(word, false);
        }
        backtracking(beginWord, endWord, visited, 1);
        return (num == Integer.MAX_VALUE ? 0 : num);
    }

    /**
     * 回溯
     *
     * @param cur     当前访问节点
     * @param endWord 结束节点
     * @param visited 访问标志列表
     * @param layer   第几层
     */
    private void backtracking(String cur, String endWord, Map<String, Boolean> visited, int layer) {
        if (layer >= num) return;
        if (cur.equals(endWord)) {
            num = layer;
            return;
        }

        for (String word : adjList.get(cur)) {
            if (visited.get(word)) continue;
            visited.replace(word, true);
            backtracking(word, endWord, visited, layer + 1);
            visited.replace(word, false);
        }
    }

    /**
     * 获取单词列表中的每个单词的相邻单词列表
     *
     * @param wordList 单词列表
     * @return 邻接表
     */
    private Map<String, List<String>> buildLists(List<String> wordList) {
        Map<String, List<String>> lists = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            lists.put(wordList.get(i), new ArrayList<String>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (word1.length() != word2.length()) continue;
                int count = 0;
                for (int k = 0; k < word1.length() && count < 2; k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        count++;
                    }
                }
                if (count == 1) {
                    if (!lists.get(word1).contains(word2)) lists.get(word1).add(word2);
                    if (!lists.get(word2).contains(word1)) lists.get(word2).add(word1);
                }
            }
        }
        return lists;
    }

    /**
     * 获取单词列表中的每个单词的相邻单词列表
     *
     * @param wordList 单词列表
     * @return 邻接表
     */
    private Map<String, List<String>> buildLists2(List<String> wordList) {
        Map<String, List<String>> virtualLists = new HashMap<>();
        for (String word : wordList) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char c = chars[i];
                chars[i] = '*';
                String s = new String(chars);
                if (!virtualLists.containsKey(s)) {
                    virtualLists.put(s, new ArrayList<>());
                }
                virtualLists.get(s).add(word);
                chars[i] = c;
            }
        }
        System.out.println("virtualLists = " + virtualLists);

        Map<String, List<String>> lists = new HashMap<>();
        for (String word : wordList) {
            lists.put(word, new ArrayList<String>());
        }
        for (String key : virtualLists.keySet()) {
            List<String> list = virtualLists.get(key);
            if (list.size() <= 1) continue;
            for (int i = 0; i < list.size(); i++) {
                String word1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    String word2 = list.get(j);
                    if (!lists.get(word1).contains(word2)) lists.get(word1).add(word2);
                    if (!lists.get(word2).contains(word1)) lists.get(word2).add(word1);
                }
            }
        }

        return lists;
    }
}

