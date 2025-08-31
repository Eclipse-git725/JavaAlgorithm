package algorithm;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 文件名称: TopKNums.java
 * 作者: gxy
 * 创建日期: 2025/5/13
 * 描述: 很大的文件中读取前k个数
 */

public class TopKNums {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // 输入文件路径
        String outputFile = "output.txt"; // 输出文件路径
        int k = 10; // 要找的前k个最大数
        try {
            // 读取文件中的数字并维护一个小根堆
            PriorityQueue<Integer> minHeap = readAndMaintainMinHeap(inputFile, k);
            // 将小根堆中的元素写入输出文件
            writeToFile(outputFile, minHeap);
            System.out.println("Top " + k + " numbers have been written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件中的数字并维护一个小根堆
     */
    private static PriorityQueue<Integer> readAndMaintainMinHeap(String filePath, int k) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                int number = Integer.parseInt(line.trim());
                if (minHeap.size() < k) {
                    minHeap.offer(number);
                } else if (number > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(number);
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + line);
            }
        }
        reader.close();

        return minHeap;
    }

    /**
     * 将小根堆中的元素写入输出文件
     */
    private static void writeToFile(String filePath, PriorityQueue<Integer> heap) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        // 将堆中的元素按降序写入文件
        while (!heap.isEmpty()) {
            writer.write(heap.poll().toString());
            writer.newLine();
        }
        writer.close();
    }
}



