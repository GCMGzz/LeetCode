import java.util.HashSet;

/**
 * @ author  wilbur
 * @ date   2020/10/13 22:23
 * @ 题目描述                判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *                                                   数字1-9在每一行只能出现一次。
 *                                                  数字1-9在每一列只能出现一次。
 *                                                  数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *
 * @ 解题思路       如何确定第几个方格？
 *                  9 * 9 划分成 3 * 3个方格 = 9行划分成3份行格，9列也划分成3份列格。
 *
 *              9行划分成3份行格
 *              i / 3 ，确定是第几份行格。
 *              如，第8行，8/3 = 2，第8行属于第2份行格（起始行为第0行）
 *
 *              9列也划分成3份列格
 *              j / 3, 确定是第几份列格。
 *              如，第5行，5/3 = 1，第8行属于第1份行格（起始行为第0行）
 *
 *              方格索引
 *              9 * 9 划分成 3 * 3个方格，行格下标为i / 3，列格下标为j / 3，也就是【x，y】=【i/3 , j/3】
 *              那么处于第几个方格就可以算出来了：x * 列格数 + y = i / 3 * 3 + j / 3
 *
 */
public class IsValidSudoku36 {

    //哈希数组
    public boolean isValidSudoku36(char[][] board) {

        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.')  continue;
                int tmp = board[i][j] - '0'; //char--> integer
                if (rows[i].contains(tmp) //本行中已有数字
                        || cols[j].contains(tmp) //本列中已有数字
                        || boxes[(i / 3) * 3 + j / 3].contains(tmp)) //本方格中已有数字
                    return false;
                rows[i].add(tmp); //添加到本行
                cols[j].add(tmp); //添加到本列
                boxes[(i / 3) * 3 + j / 3].add(tmp); //添加到本方格

            }
        }

        return  true;
    }
    //位运算
}


