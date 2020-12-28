/**
 * @ author  wilbur
 * @ date   2020/12/28 9:53
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
 */
public class SingleNumber136b {
    public int singleNumber(int[] nums) {
        // 1、Map
//        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for(int num:nums){
//            if(map.containsKey(num)){
//                map.put(num,2);
//            }else map.put(num,1);
//        }
//        for(Integer key:map.keySet()){
//            if(map.get(key)==1){
//                return key;
//            }
//        }
//        return 0;

        //2、  位运算
        int ans =0;
        //异或
        //两位相同为0 相异为1。 满足 交换律和结合律
        //a^b^c^b^c = a^(b^b)^(c^c) = a^0^0 = a
        for(int x : nums){
            ans^=x;
        }
        return ans;
    }
}
