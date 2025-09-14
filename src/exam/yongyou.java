package exam;

import java.util.*;

/**
 * 文件名称: yongyou.java
 * 作者: gxy
 * 创建日期: 2025/9/12
 * 描述: 用友笔试
 */
public class yongyou {
    public static void main(String[] args) {
        // 年龄分段判断器，要求年龄连续
//        Scanner in = new Scanner(System.in);
//        //(0,20],(20,40],(40,60],(60,99]
//        String input = in.nextLine();
//        String[] ages = input.split("]");
//        for(int i = 1; i < ages.length; i ++ ) {
//            ages[i] = ages[i].substring(1);
//        }
//        List<int[]> age = new ArrayList<>();
//        //System.out.println(ages[1]);
//        for(int i = 0; i < ages.length; i ++ ) {
//            int split = ages[i].indexOf(',');
////            System.out.println(ages[i].substring(1, split));
////            System.out.println(ages[i].substring(split + 1));
//            int age1 = Integer.parseInt(ages[i].substring(1, split));
//            int age2 = Integer.parseInt(ages[i].substring(split + 1));
//            if(age1 > age2) {
//                System.out.println("false");
//                return ;
//            }
//            if(age1 > 99) {
//                age1 = 99;
//            }
//            if(age2 > 99) {
//                age2 = 99;
//            }
//            age.add(new int[]{age1, age2});
//        }
//        //System.out.println(age.get(0)[0] + " " + age.get(0)[1]);
//        age.sort((a, b) -> {
//            return a[0] - b[0];
//        });
//        for(int i = 1; i < age.size(); i ++ ) {
//            if(age.get(i)[0] < age.get(i - 1)[1]) {
//                age.get(i)[0] = age.get(i - 1)[1];
//            }
//        }
//        age.get(0)[0] = 0;
//        age.get(age.size() - 1)[1] = 99;
//        StringBuilder ans = new StringBuilder();
//        for(int i = 0; i < age.size(); i ++ ) {
//            if(i > 0) {
//                ans.append(',');
//            }
//            ans.append('(');
//            String age1 = String.valueOf(age.get(i)[0]);
//            String age2 = String.valueOf(age.get(i)[1]);
//            ans.append(age1);
//            ans.append(',');
//            ans.append(age2);
//            ans.append(']');
//        }
//        System.out.println(ans.toString());

        /*
        3
        1 4 3
        2 6 2
        5 7 4
         */
        // 求完成一批任务最少需要的任务节点
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] tasks = new int[n][3];
//        for(int i = 0; i < n; i ++ ) {
//            int start = in.nextInt();
//            int end = in.nextInt();
//            int p = in.nextInt();
//            tasks[i][0] = start;
//            tasks[i][1] = end;
//            tasks[i][2] = p;
//        }
//        Arrays.sort(tasks, (a, b) -> {
//            return a[0] - b[0];
//        });
//        int ans = 0;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            return a[0] - b[0];
//        });
//        int sum = 0;
//        for(int i = 0; i < n; i ++ ) {
//            sum += tasks[i][2];
//            while(!pq.isEmpty() && pq.peek()[0] < tasks[i][0]) {
//                int[] t = pq.poll();
//                sum -= t[1];
//            }
//            pq.add(new int[]{tasks[i][1], tasks[i][2]});
//            ans = Math.max(ans, sum);
//        }
//        System.out.println(ans);

        // 每个人完成一个工作，工作难度要小于自己能力，要求最大收益
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int[] task = new int[m];
//        int[] profit = new int[m];
//        int[] ability = new int[n];
//        for(int i = 0; i < m; i ++ ) {
//            task[i] = in.nextInt();
//        }
//        for(int i = 0; i < m; i ++ ) {
//            profit[i] = in.nextInt();
//        }
//        for(int i = 0; i < n; i ++ ) {
//            ability[i] = in.nextInt();
//        }
//        int[][] tasks = new int[m][2];
//        for(int i = 0; i < m; i ++ ) {
//            tasks[i][0] = task[i];
//            tasks[i][1] = profit[i];
//        }
//        Arrays.sort(tasks, (a, b) -> {
//            return a[0] - b[0];
//        });
//        long ans = 0;
//        for(int i = 0; i < n; i ++ ) {
//            int target = ability[i];
//            int l = 0, r = m - 1;
//            int res = 0;
//            for(int j = 0; j < m; j ++ ) {
//                if(tasks[j][0] <= ability[i]) {
//                    res = Math.max(res, tasks[j][1]);
//                }else {
//                    break;
//                }
//            }
//            ans += res;
//        }
//        System.out.println(ans);

        // 商品促销策略
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] split = input.split(",");
        String name = split[0];
        int money = Integer.parseInt(split[1]);
        int num = Integer.parseInt(split[2]);
        double sum = money * num;
        List<String> stat = new ArrayList<>();
        double num1 = sum;
        double num2 = sum;
        double num3 = sum;
        if(sum >= 300) {
            stat.add("满减促销");
            num1 -= 80;
        }
        if(money >= 100) {
            num2 *= 0.85;
            stat.add("折扣促销");
        }
        if(num >= 5) {
            num3 *= 0.75;
            stat.add("会员专享");
        }
        double best = Math.min(num1, Math.min(num2, num3));
        System.out.println("商品信息: " + name + ", " + "单价: " + money + ", 数量: " + num);
        System.out.println("原始金额: " + money * num);
        System.out.println("最优金额: " + String.format("%.0f", best));
        System.out.print("应用促销: ");
        if(best == num1) {
            System.out.print("满减促销");
        }else if(best == num2) {
            System.out.print("折扣促销");
        }else {
            System.out.print("会员专享");
        }
        System.out.println();
        System.out.println("节省金额: " + String.format("%.0f", (double)money * num - best));
        System.out.println("实付比例: " + String.format("%.1f",best / (double)(money * num) * 100) + "%");

    }
}
