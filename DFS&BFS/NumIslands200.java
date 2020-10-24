/**
 * @ author  wilbur
 * @ date   2020/10/23 22:39
 */

import java.util.LinkedList;

/**
 * 方法一：深度优先遍历 DFS
 */
public class NumIslands200 {

    //           x-1,y
    //  x,y-1    x,y      x,y+1
    //           x+1,y
    // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧
//                                     -1 0
//                                      0 -1
//                                      1  0
//                                      0  1
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    // 标记数组，标记了 grid 的坐标对应的格子是否被访问过
    private boolean[][] marked;
    // grid 的行数
    private int rows;
    // grid 的列数
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 就进行深度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    // 从坐标为 (i,j) 的点开始进行深度优先遍历
    private void dfs(int i, int j) {
        marked[i][j] = true;
        // 得到 4 个方向的坐标
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            // 如果不越界、没有被访问过、并且还要是陆地
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    // 封装成 inArea 方法语义更清晰
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * 方法二：广度优先遍历  BFS
     */
     class Solution2 {


        private int rows;
        private int cols;

        public int numIslands(char[][] grid) {
            //           x-1,y
            //  x,y-1    x,y      x,y+1
            //           x+1,y
            int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            rows = grid.length;
            if (rows == 0) {
                return 0;
            }
            cols = grid[0].length;
            boolean[][] marked = new boolean[rows][cols];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 如果是岛屿中的一个点，并且没有被访问过
                    // 从坐标为 (i,j) 的点开始进行广度优先遍历
                    if (!marked[i][j] && grid[i][j] == '1') {
                        count++;
                        LinkedList<Integer> queue = new LinkedList<>();
                        // 小技巧：把坐标转换为一个数字
                        // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                        queue.addLast(i * cols + j);
                        // 注意：这里要标记上已经访问过
                        marked[i][j] = true;
                        while (!queue.isEmpty()) {
                            int cur = queue.removeFirst();
                            int curX = cur / cols;
                            int curY = cur % cols;
                            // 得到 4 个方向的坐标
                            for (int k = 0; k < 4; k++) {
                                int newX = curX + directions[k][0];
                                int newY = curY + directions[k][1];
                                // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                                if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                    queue.addLast(newX * cols + newY);
                                    // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                    // 而不是在出队列的时候再标记
                                    // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                    marked[newX][newY] = true;
                                }
                            }
                        }
                    }
                }

            }
            return count;
        }

        private boolean inArea(int x, int y) {
            // 等于号这些细节不要忘了
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

    }

}

