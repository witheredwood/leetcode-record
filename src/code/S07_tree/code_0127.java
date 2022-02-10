package code.S07_tree;

import java.util.*;

public class code_0127 {
    Map<String, List<String>> adjList = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    int num = Integer.MAX_VALUE;

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

