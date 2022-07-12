package code.S02_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class code_0015Test extends code_0015 {

  @Test
  void testThreeSum() {
//    int[] nums = {0};
    int[] nums = {};
    List<List<Integer>> res = threeSum(nums);
    System.out.println(res);
  }
}
