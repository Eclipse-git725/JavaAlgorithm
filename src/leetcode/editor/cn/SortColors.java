//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1986 👎 0

  
package leetcode.editor.cn;
public class SortColors{
  public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
       // 四指针
      int[] nums = new int[]{1, 3, 1, 2, 0, 0};
      int n = nums.length;
      int p0 = 0, p1 = 0, cur = 0, p3 = n - 1;
      while(cur <= p3) {
          if(nums[cur] == 0) {
              swap(nums, p0, cur);
              p0 ++;
              if(p1 < p0) {
                  p1 = p0;
              }
          }else if(nums[cur] == 1) {
              swap(nums, cur, p1);
              cur ++;
              p1 ++;
          }else if(nums[cur] == 3) {
              swap(nums, cur, p3);
              p3 --;
          }else if(nums[cur] == 2){
              cur ++;
          }
      }
      for(int i = 0; i < n; i ++ ) {
          System.out.print(nums[i] + " ");
      }
  }
  public static void swap(int[] nums, int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1, cur = 0;
        while(cur <= p2) {
            if(nums[cur] == 0) {
                int t = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = t;
                p0 ++;
                cur ++;
            }else if(nums[cur] == 2) {
                int t = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = t;
                p2 --;
                // 这里cur不加一，不确定p2换的数是什么
            }else {
                cur ++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
