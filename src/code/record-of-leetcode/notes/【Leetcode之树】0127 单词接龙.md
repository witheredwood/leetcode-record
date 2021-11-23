来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/word-ladder

实现语言：Java

@[TOC](目录)

##  题目

字典 `wordList` 中从单词 `beginWord` 和 `endWord` 的 转换序列 是一个按下述规格形成的序列：

- 序列中第一个单词是 `beginWord` 。

- 序列中最后一个单词是 `endWord` 。

- 每次转换只能改变一个字母。

- 转换过程中的中间单词必须是字典 `wordList` 中的单词。

  给你两个单词 `beginWord` 和 `endWord` 和一个字典 `wordList` ，找到从 `beginWord` 到 `endWord` 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。

**示例**

```
输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
输出：5
解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。

输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
输出：0
解释：endWord "cog" 不在字典中，所以无法进行转换。
```

提示：

- 1 <= beginWord.length <= 10
- endWord.length == beginWord.length
- 1 <= wordList.length <= 5000
- wordList[i].length == beginWord.length
- beginWord、endWord 和 wordList[i] 由小写英文字母组成
- beginWord != endWord
- wordList 中的所有字符串 互不相同

## 方法：广度优先遍历

广度优先遍历：以顶点v为起点，由近至远依次访问与v有路径相通，且路径长度为1，2，··· 的顶点。

广度优先遍历是一种分层的查找过程，每向前走一步可能访问一批顶点，不像深度优先遍历那样有回退的情况，所有不是一个递归的算法。广度优先遍历需要借助一个队列，以记录正在访问的顶点的下一层顶点。

在本题中，每个单词相当于一个顶点，那么，两个单词可以转换，则表示两个顶点之间有边相连。题目所要求的问题：找到从 `beginWord` 到 `endWord` 的 最短转换序列 ，也就是，在这些顶点中，找到一条初始顶点 `beginWord` 到终止顶点 `endWord` 的最短路径。将题目转换为树或图，就可以按照树或图的结构进行解题，可以使用广度优先遍历寻找符合要求的路径。

在例子

`beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]`

中

构造出来的图的结构如下所示。

<img src="【Leetcode之树】0127 单词接龙.assets/image-20210421211333589.png" alt="image-20210421211333589" style="zoom:50%;" />

使用广度优先遍历，一次遍历与当前顶点相连的所有边，所有的顶点只遍历一次，找到顶点 `endWord`  则表示在 `wordList` 中可以找到一条最短转换路径，反之，则是找不到一条满足要求的最短转换序列。每次遍历的顶点如下。

<img src="【Leetcode之树】0127 单词接龙.assets/image-20210421211756509.png" alt="image-20210421211756509" style="zoom:50%;" />



**代码实现**

```java
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) return 0;
     
     Map<String, Boolean> visited = new HashMap<>();  // 访问标志数组
    // 初始化标记数组
    visited.put(beginWord, false);
    for (int i = 0; i < wordList.size(); i++) {
        visited.put(wordList.get(i), false);
    }
    LinkedList<String> queue = new LinkedList<>();  // 辅助队列
    queue.offer(beginWord);  // 从beginWord开始访问
    int count = 1;
    String last = queue.peekLast();  // 队列中每层的最后一个节点
    if (!visited.get(beginWord)) {
        visited.replace(beginWord, true);  // 邻访问标志置true
		// 队列不为空时，逐层遍历节点
        while (!queue.isEmpty()) {
            String cur = queue.poll();  // 队首节点出队

            // 查找课转换的单词列表
            List<String> list = new LinkedList<>();
            int j = wordList.indexOf(cur);
            for (int i = 0; i < wordList.size(); i++) {
                // 该单词没有被访问过，且可以由当前单词转换得到
                if (!visited.get(wordList.get(i)) && isTransport(cur, wordList.get(i))) {
                    list.add(wordList.get(i));
                }
            }
            for (int i=0; i<list.size(); i++) {  // 所有邻接点入队
                if (!visited.get(list.get(i))) {
                    visited.replace(list.get(i), true);  // 邻接点的访问标志置true
                    queue.offer(list.get(i));  // 入队
                }
            }
            // 找到了到达endWord的路径
            if (cur.equals(endWord)) {
                return count;
            }
            // 更新新一层的最后一个节点标志
            if (cur.equals(last)) {
                count++;
                last = queue.peekLast();
            }
            
        }
    }
		// 	没有找到到达endWord的路径
        return 0;
    }

    // 判断两个字符串是否可以转换
    public boolean isTransport(String a, String b) {
        if (a.length() != b.length()) return false;
        int res = 0;
        for (int i=0; i<a.length() && res<=1; i++) {
            if (a.charAt(i) != b.charAt(i)) res++;
        }
        if (res==1) return true;
        return false;
    }
}
```

时间复杂度：O( N×C^2 )。其中 N 为  `wordList` 的长度，C 为列表中单词的长度。

- 建图过程中，对于每一个单词，我们需要枚举它连接到的所有邻接节点，时间复杂度为 O(C)，将这些单词加入到哈希表中，时间复杂度为 O(N×C)，因此总时间复杂度为 O(N×C)。

- 广度优先搜索的时间复杂度最坏情况下是 O( N×C )。每一个单词需要拓展出 O(C) 个邻接节点，因此节点数 O(N×C)。

空间复杂度：O( N×C^2 ) 

- 哈希表中包含 O(N×C) 个节点，每个节点占用空间 O(C)，因此总的空间复杂度为 O(N×C^2)。

执行用时：1507 ms

内存消耗：39.3 MB
