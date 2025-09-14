package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名称: hikvision.java
 * 作者: gxy
 * 创建日期: 2025/9/14
 * 描述: 海康威视笔试
 */
public class hikvision {
    public static void main(String[] args) {

    }
    class Solution {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        private static final String seprator = "_";
        private static final int MIN_Seq = 1;
        private static final int MAX_Seq = 99999;
        int curNum = 1;
        public Solution() {
        }

        public String generateOrderNumber(Date date, String userId) {
            String time = simpleDateFormat.format(date);
            String num = String.format("%05d", curNum);
            if(curNum == MAX_Seq) {
                curNum = MIN_Seq;
            }
            return time + seprator + num + seprator + userId;
        }

        public Order getOrder(String orderNumber) {
            if(orderNumber == null) {
                throw new IllegalArgumentException("订单号不能为空");
            }
            String[] parts = orderNumber.split(seprator);
            if(parts.length < 3) {
                throw new IllegalArgumentException("订单号错误");
            }
            try {
                Date date = simpleDateFormat.parse(parts[0]);
                String num = parts[1];
                String userId = parts[2];
                Order order = new Order(date, num, userId);
                return order;
            }catch (ParseException e) {
                throw new IllegalArgumentException("日期格式错误");
            }
        }

    }
    class Order {
        private Date createDate;
        private String orderSerial;
        private String userId;

        public Order(Date createDate, String orderSerial, String userId) {
            this.createDate = createDate;
            this.orderSerial = orderSerial;
            this.userId = userId;
        }

        public String getOrderSerial() {
            return orderSerial;
        }

        public String getUserId() {
            return userId;
        }

        public Date getCreateDate() {
            return createDate;
        }
    }
}
