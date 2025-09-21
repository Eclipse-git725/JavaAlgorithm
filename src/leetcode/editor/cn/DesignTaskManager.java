//一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。 
//
// 请你设计一个 TaskManager 类： 
//
// 
// TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, 
//priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。 
// void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 
//priority 的任务 taskId ，输入 保证 taskId 不在系统中。 
// void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入
// 保证 taskId 存在于系统中。 
// void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。 
// int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任
//务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。 
// 
//
// 注意 ，一个用户可能被安排多个任务。 
//
// 
//
// 示例 1： 
//
// 
// 输入： ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"] [[[[1,
// 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 1
//05, 15], []] 
// 
//
// 输出： [null, null, null, 3, null, null, 5] 
//
// 解释： TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3
//, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
// taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
// taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
// taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
// taskManager.rmv(101); // 将系统中的任务 101 删除。
// taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
// taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 10⁵ 
// 0 <= userId <= 10⁵ 
// 0 <= taskId <= 10⁵ 
// 0 <= priority <= 10⁹ 
// 0 <= newPriority <= 10⁹ 
// add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 10⁵ 次。 
// 输入保证 taskId 是合法的。 
// 
//
// Related Topics 设计 哈希表 有序集合 堆（优先队列） 👍 9 👎 0


package leetcode.editor.cn;

import java.util.*;

public class DesignTaskManager {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 101, 8)));
        list.add(new ArrayList<>(Arrays.asList(2, 102, 20)));
        list.add(new ArrayList<>(Arrays.asList(3, 103, 5)));
        TaskManager taskManager = new DesignTaskManager().new TaskManager(list);
        taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
        taskManager.edit(102, 9); // 更新任务 102 的优先级为 9 。
        System.out.println(taskManager.execTop()); // 返回 3 。执行用户 3 的任务 103 。
        taskManager.rmv(101); // 将系统中的任务 101 删除。
        taskManager.add(5, 101, 8); // 给用户 5 添加优先级为 15 的任务 105 。
        System.out.println(taskManager.execTop()); // 返回 5 。执行用户 5 的任务 105 。
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TaskManager {
        // taskId -> (priority, userId)
        private final Map<Integer, int[]> map = new HashMap<>();
        // (priority, taskId, userId)
        private final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        public TaskManager(List<List<Integer>> tasks) {
            for(int i = 0; i < tasks.size(); i ++ ) {
                add(tasks.get(i).get(0), tasks.get(i).get(1), tasks.get(i).get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            map.put(taskId, new int[]{priority, userId});
            pq.add(new int[]{priority, taskId, userId});
        }

        public void edit(int taskId, int newPriority) {
            int userId = map.get(taskId)[1];
            add(userId, taskId, newPriority);
        }

        public void rmv(int taskId) {
            map.get(taskId)[0] = -1;
        }

        public int execTop() {
            while(!pq.isEmpty()) {
                int[] t = pq.poll();
                if(map.get(t[1])[0] == t[0] && map.get(t[1])[1] == t[2]) {
                    rmv(t[1]);
                    return t[2];
                }
            }
            return -1;
        }
    }

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
