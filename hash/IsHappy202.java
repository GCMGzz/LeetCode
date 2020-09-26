import java.util.HashSet;
import java.util.Set;

/**
 * @ author  wilbur
 * @ date   2020/9/26 18:24
 * @ 题目描述                         定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 *                                           如果 可以变为 1，那么这个数就是快乐数。
 *
 * @ 解题思路                     首先定义一个Set集合，用来存放计算后的平方和m，如果m在Set中已存在，即进入了死循环，则退出；
 *                                         如果m不存在Set，则将m放入Set；
 *                                       直至找到平方和为1或者set集合中存在该平方和（进入死循环）就退出。
 */
public class IsHappy202 {
    //1
    public boolean isHappy1(int n) {
        Set<Integer> set =new HashSet<>();
        int  m  =0;
        while(true){
            while (n!=0){
                m+=Math.pow(n%10,2);
                n/=10;
            }
            if (m==1){
                return true;
            }
            if (set.contains(m)){
                return false;
            }else {
                set.add(m);
                n=m;
                m=0;
            }
        }
    }
    //2、快慢指针
    //我们不是只跟踪链表中的一个值，而是跟踪两个值，称为快跑者和慢跑者。在算法的每一步中，慢速在链表中前进 1 个节点，快跑者前进 2 个节点（对 getNext(n) 函数的嵌套调用）。
    //
    //如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
    //
    //如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
    //

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


}
