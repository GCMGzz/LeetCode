import java.util.HashSet;

/**
 * @ author  wilbur
 * @ date   2020/12/23 15:42
 *
 * //给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 如果糖果的种类超出数量的一半，返回数量的一半即可（均分）
 * 如果糖果的种类小于数量的一半，返回糖果种类即可
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candy = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            candy.add(candyType[i]);
        }
        return Math.min(candy.size(),candyType.length/2);
    }
}
