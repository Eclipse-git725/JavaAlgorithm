//给你三个长度为 n 的数组，分别描述 n 个优惠券的属性：code、businessLine 和 isActive。其中，第 i 个优惠券具有以下属性： 
//
// 
// code[i]：一个 字符串，表示优惠券的标识符。 
// businessLine[i]：一个 字符串，表示优惠券所属的业务类别。 
// isActive[i]：一个 布尔值，表示优惠券是否当前有效。 
// 
//
// 当以下所有条件都满足时，优惠券被认为是 有效的 ： 
//
// 
// code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。 
// businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。 
//
// isActive[i] 为 true 。 
// 
//
// 返回所有 有效优惠券的标识符 组成的数组，按照以下规则排序： 
//
// 
// 先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。 
// 在每个类别内，再按照 标识符的字典序（升序）排序。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant",
//"grocery","pharmacy","restaurant"], isActive = [true,true,true,true] 
// 
//
// 输出： ["PHARMA5","SAVE20"] 
//
// 解释： 
//
// 
// 第一个优惠券有效。 
// 第二个优惠券的标识符为空（无效）。 
// 第三个优惠券有效。 
// 第四个优惠券的标识符包含特殊字符 @（无效）。 
// 
//
// 示例 2： 
//
// 
// 输入： code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = [
//"grocery","electronics","invalid"], isActive = [false,true,true] 
// 
//
// 输出： ["ELECTRONICS_50"] 
//
// 解释： 
//
// 
// 第一个优惠券无效，因为它未激活。 
// 第二个优惠券有效。 
// 第三个优惠券无效，因为其业务类别无效。 
// 
//
// 
//
// 提示： 
//
// 
// n == code.length == businessLine.length == isActive.length 
// 1 <= n <= 100 
// 0 <= code[i].length, businessLine[i].length <= 100 
// code[i] 和 businessLine[i] 由可打印的 ASCII 字符组成。 
// isActive[i] 的值为 true 或 false。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 3 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CouponCodeValidator {
    public static void main(String[] args) {
        Solution solution = new CouponCodeValidator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
            int n = code.length;
            List<String[]> ans = new ArrayList<>();
            for(int i = 0; i < n; i ++ ) {
                if(code[i].length() == 0) {
                    continue;
                }
                boolean flag = true;
                for(int j = 0; j < code[i].length(); j ++ ) {
                    char ch = code[i].charAt(j);
                    if(ch == '_' || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                        continue;
                    }else {
                        flag = false;
                    }
                }
                if(!flag) continue;
                if(!businessLine[i].equals("electronics") && !businessLine[i].equals("grocery") && !businessLine[i].equals("pharmacy") && !businessLine[i].equals("restaurant")) {
                    continue;
                }
                if(isActive[i] == false) {
                    continue;
                }
                String[] t = new String[2];
                t[0] = code[i];
                t[1] = businessLine[i];
                ans.add(t);
            }
            // 排序
            Map<String, Integer> map = new HashMap<>();
            map.put("electronics", 0);
            map.put("grocery", 1);
            map.put("pharmacy", 2);
            map.put("restaurant", 3);
            ans.sort((a, b) -> {
                int p = map.get(a[1]);
                int q = map.get(b[1]);
                if(p != q) {
                    return p - q;
                }else {
                    return a[0].compareTo(b[0]);
                }
            });
            List<String> res = new ArrayList<>();
            for(int i = 0; i < ans.size(); i ++ ) {
                res.add(ans.get(i)[0]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
