package algorithm;

/**
 * 文件名称: HashMap.java
 * 作者: gxy
 * 创建日期: 2025/4/23
 * 描述: 手撕HashMap
 */

//public class MyHashMap<K, V> {
//    static class Node<K, V> {
//        final K key;
//        V value;
//        Node<K, V> next;
//        Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private Node<K, V>[] table;
//    private int size;
//    private float loadFactor = 0.75f;
//    private int threshold;
//
//    public MyHashMap() {
//        this.threshold = 16; // 默认初始容量
//    }
//
//    // 这里继续添加其他方法（put/get/resize等）
//    public V put(K key, V value) {
//        // 1. 懒初始化数组
//        if (table == null || table.length == 0) {
//            resize();
//        }
//
//        // 2. 计算哈希和桶下标
//        int hash = hash(key);
//        int index = (table.length - 1) & hash;
//
//        // 3. 处理桶为空的情况
//        Node<K, V> head = table[index];
//        if (head == null) {
//            table[index] = new Node<>(key, value);
//        } else {
//            // 4. 遍历链表或红黑树（简化版仅处理链表）
//            Node<K, V> cur = head;
//            while (true) {
//                // 4.1 键已存在：更新值
//                if (cur.key.equals(key)) {
//                    V oldValue = cur.value;
//                    cur.value = value;
//                    return oldValue;
//                }
//                // 4.2 到达链表末尾：插入新节点
//                if (cur.next == null) {
//                    cur.next = new Node<>(key, value);
//                    break;
//                }
//                cur = cur.next;
//            }
//        }
//
//        // 5. 检查扩容
//        if (++size > threshold) {
//            resize();
//        }
//        return null;
//    }
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    private void resize() {
//        int oldCap = (table == null) ? 0 : table.length;
//        int newCap = (oldCap == 0) ? threshold : oldCap << 1;
//        threshold = (int)(newCap * loadFactor);
//        Node<K, V>[] newTable = new Node[newCap];
//
//        if (table != null) {
//            // 迁移旧数据到新数组
//            for (int i = 0; i < oldCap; i++) {
//                Node<K, V> node = table[i];
//                while (node != null) {
//                    Node<K, V> next = node.next;
//                    int newIndex = (newCap - 1) & hash(node.key);
//                    node.next = newTable[newIndex];
//                    newTable[newIndex] = node;
//                    node = next;
//                }
//            }
//        }
//        table = newTable;
//    }
//
//    // get方法（核心逻辑）
//    public V get(K key) {
//        if (table == null || table.length == 0) {
//            return null; // 空表直接返回null
//        }
//
//        int hash = hash(key);
//        int index = (table.length - 1) & hash; // 计算桶下标
//
//        // 遍历链表查找key
//        Node<K, V> node = table[index];
//        while (node != null) {
//            if (node.key.equals(key)) { // 注意：先比较hash再equals更高效（简化版未体现）
//                return node.value;
//            }
//            node = node.next;
//        }
//        return null; // 未找到
//    }
//
//    public static void main(String[] args) {
//        MyHashMap<String, Integer> map = new MyHashMap<>();
//        map.put("a", 1);
//        map.put("b", 2);
//        System.out.println(map.get("a")); // 输出 1
//    }
//}

public class MyHashMap {

    static class Node {
        int key, value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 哈希表的数组，数组中放的是链表的头节点
    private final int CAPACITY = 1024;
    Node[] nodes = new Node[CAPACITY];

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = nodes[index];
        Node pre = null;
        Node cur = head;

        // 同时查找key和尾节点
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value; // 更新已存在的值
                return;
            }
            pre = cur;
            cur = cur.next;
        }

        // 插入新节点（pre指向尾节点）
        Node newNode = new Node(key, value);
        if (pre == null) {
            nodes[index] = newNode; // 空链表直接插入
        } else {
            pre.next = newNode;   // 非空链表插入尾部
        }
    }

    public int get(int key) {
        int id = getIndex(key);
        Node cur = nodes[id];

        while(cur != null) {
            if(cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }

        return -1;
    }

    private int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16); // 哈希扰动函数，减少哈希冲突概率
        //return hash % CAPACITY;
        return hash & (CAPACITY - 1); // 如果容量是2的幂次
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node cur = nodes[index];
        Node pre = null;
        while (cur != null) {
            if (cur.key == key) {
                if (pre == null) {
                    nodes[index] = cur.next;  // 删除头节点
                } else {
                    pre.next = cur.next;     // 删除中间或尾节点
                }
                return;  // 找到并删除后立即返回
            }
            pre = cur;
            cur = cur.next;
        }
    }

}