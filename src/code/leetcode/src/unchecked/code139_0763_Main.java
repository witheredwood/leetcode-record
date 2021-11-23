package unchecked;

import java.util.List;

public class code139_0763_Main {
    public static void main(String[] args) {
        code139_0763 one = new code139_0763();

        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = one.partitionLabels(s);
        System.out.println("res="+res);
    }
}
