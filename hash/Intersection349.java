import java.util.HashSet;

/**
 * @ author  wilbur
 * @ date   2020/9/26 16:04
 * @ 题目描述                   给定两个数组，编写一个函数来计算它们的交集。
 * @ 解题思路                   set.retainAll()
 */
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<Integer>();
        for(int n:nums1) set1.add(n);
        HashSet<Integer>set2=new HashSet<Integer>();
        for(int m:nums2) set2.add(m);
        set1.retainAll(set2);
        int[]ans =new int[set1.size()];
        int i=0;
        for(int s:set1)ans[i++]=s;
        return ans;
    }
}
