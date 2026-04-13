//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ： 
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，并继续执行下一个命令。 
//
// 返回机器人距离原点的 最大欧式距离 的 平方 。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
// 
//
// 
// 北方表示 +Y 方向。 
// 东方表示 +X 方向。 
// 南方表示 -Y 方向。 
// 西方表示 -X 方向。 
// 原点 [0,0] 可能会有障碍物。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 3² + 4² = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 1² + 8² = 65 
//
// 示例 3： 
//
// 
//输入：commands = [6,-1,-1,6], obstacles = []
//输出：36
//解释：机器人开始位于 (0, 0):
//1. 向北移动 6 个单位，到达 (0, 6).
//2. 右转
//3. 右转
//4. 向南移动 6 个单位，到达 (0, 0).
//机器人距离原点最远的点是 (0, 6)，其距离的平方是 6² = 36 个单位。 
//
// 提示： 
//
// 
// 1 <= commands.length <= 10⁴ 
// commands[i] 的值可以取 -2、-1 或者是范围 [1, 9] 内的一个整数。 
// 0 <= obstacles.length <= 10⁴ 
// -3 * 10⁴ <= xi, yi <= 3 * 10⁴ 
// 答案保证小于 2³¹ 
// 
//
// Related Topics 数组 哈希表 模拟 👍 270 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
            HashSet<Integer> s = new HashSet<>();

            int offset = 30000;
            for(int i = 0; i < obstacles.length; i ++ ) {
                int x = obstacles[i][0], y = obstacles[i][1];
                s.add(((x + offset) << 16) | (y + offset));
            }

            int d = 0;
            int x = 0, y = 0;
            int ans = 0;
            for(int c : commands) {
                if(c == -1) {
                    d = (d + 1) % 4;
                }else if(c == -2) {
                    d = (d + 3) % 4;
                }else {
                    for(int i = 0; i < c; i ++ ) {
                        x += dx[d];
                        y += dy[d];
                        if(s.contains(((x + offset) << 16) | (y + offset))) {
                            x -= dx[d];
                            y -= dy[d];
                            break;
                        }
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
