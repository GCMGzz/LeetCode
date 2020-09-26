import java.util.*;

/**
 * @ author  wilbur
 * @ date   2020/9/26 15:42
 * @ 题目描述               给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @ 解题思路               HashSet / HashMap                      异或运算
 */
public class SingleNumber136 {

    // HashSet
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> temp = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                temp.remove(nums[i]);
            }
        }
        return temp.iterator().next();
    }


    //HashMap
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else map.put(num, 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }



    //任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
    //任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
    //异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

     public int singleNumber3(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }

}
