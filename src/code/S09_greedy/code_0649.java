package code.S09_greedy;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * 649. Dota2 参议院
 * <p>
 * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 * <p>
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
 * 他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 * 宣布胜利：如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。
 * 然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。
 * 这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，
 * 你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 * <p>
 * 示例 1：
 * 输入："RD"
 * 输出："Radiant"
 * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。
 * 然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 * 示例 2：
 * 输入："RDD"
 * 输出："Dire"
 * 解释：
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * <p>
 * 提示：
 * 给定字符串的长度在 [1, 10,000] 之间.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dota2-senate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0649 {
    /**
     * @param senate 字符串
     * @return 胜利队伍的名字
     */
    public String predictPartyVictory32(String senate) {
        StringBuilder builder = new StringBuilder(senate);
        int count = 0;  // > 0 时是 R 可以消除 D；< 0 时是 D 可以消除 R
        int index = 0;
        while (Math.abs(count) < builder.length()) {
            if (builder.charAt(index) == 'R') {  // 当前是 R
                if (count < 0) {      // 前面有 D 消除当前的 R
                    builder.deleteCharAt(index);
                } else {
                    index++;
                }
                count++;
            } else {     // 当前是 D
                if (count > 0) {     // 前面有R 消除当前的D
                    builder.deleteCharAt(index);
                } else {
                    index++;
                }
                count--;
            }
            if (index >= builder.length()) index = 0;
        }
        return 'R' == builder.charAt(0) ? "Radiant" : "Dire";
    }

    /**
     * @param senate 字符串
     * @return 胜利队伍的名字
     */
    public String predictPartyVictory31(String senate) {
        StringBuilder builder = new StringBuilder(senate);
        LinkedList<Character> queue = new LinkedList<>();
        int index = 0;
        while (queue.size() < builder.length()) {
            if (queue.isEmpty() || builder.charAt(index) == queue.peek()) {
                queue.offer(builder.charAt(index++));
            } else {
                queue.pop();
                builder.deleteCharAt(index);
            }
            if (index >= builder.length()) index = 0;
        }
        return 'R' == queue.peek() ? "Radiant" : "Dire";
    }

    /**
     * @param senate 字符串
     * @return 胜利队伍的名字
     */
    public static String predictPartyVictory(String senate) {
        StringBuilder builder = new StringBuilder(senate);
        LinkedList<Character> queue = new LinkedList<>();
        System.out.println(builder);
        int count = 0;  // count > 0，R 可以禁言其他成员；count < 0, C 可以禁言其他成员
        int index = 0;
        while (Math.abs(count) != builder.length()) {
            char c = builder.charAt(index);
            if (c == 'R') {
                if (count < 0) builder.deleteCharAt(index);
                else index++;
                count++;
            } else {
                if (count > 0) builder.deleteCharAt(index);
                else index++;
                count--;
            }
            index = index % builder.length();
        }
        return (builder.charAt(0) == 'R') ? "Radiant" : "Dire";
    }

    /**
     * @param senate 字符串
     * @return 胜利队伍的名字
     */
    public static String predictPartyVictory2(String senate) {
        StringBuilder builder = new StringBuilder(senate);
        System.out.println(builder);

        int index = 0, rCount = 0, dCount = 0;
        while (rCount != builder.length() && (dCount != builder.length())) {
            char c = builder.charAt(index);
            if (c == 'R') {
                if (dCount == 0) {
                    rCount++;
                    index++;
                } else {
                    dCount--;
                    builder.deleteCharAt(index);
                }
                index = index % builder.length();
            } else {
                if (rCount == 0) {
                    dCount++;
                    index++;
                } else {
                    rCount--;
                    builder.deleteCharAt(index);
                }
                index = index % builder.length();
            }
        }
        return (builder.charAt(0) == 'R') ? "Radiant" : "Dire";
    }

    /**
     * @param senate 字符串
     * @return 胜利队伍的名字
     */
    public static String predictPartyVictory1(String senate) {
        StringBuilder builder = new StringBuilder(senate);
        LinkedList<Character> queue = new LinkedList<>();
        System.out.println(builder);
        int index = 0;
        while (queue.size() != builder.length()) {
            char c = builder.charAt(index);
            if (queue.isEmpty() || c == queue.peek()) {
                queue.offer(c);
                index = (++index) % builder.length();
            } else {
                queue.poll();
                builder.deleteCharAt(index);
                if (index >= builder.length()) index = 0;
            }
        }
        return (builder.charAt(0) == 'R') ? "Radiant" : "Dire";
    }
}
