package algorithm;

/**
 * 文件名称: Algorithm2.java
 * 作者: gxy
 * 创建日期: 2025/4/21
 * 描述: 快速排序
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
//        quickSort(arr, 0, arr.length - 1);
//        bubbleSort(arr);
//        insertSort(arr);
//        selectSort(arr);
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 快速排序，最好O(logn) 最坏O(n^2) 不稳定
    // 空间复杂度是递归用到的空间 最好O(logn) 最坏O(n)
    // 不稳定举例 [3,2,3,1] 基准值为2，会将1和3交换，破坏3 3 的相对顺序
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = left + right >> 1;
        int i = left - 1, j = right + 1;
        while(i < j) {
            while(arr[++ i] < arr[mid]);
            while(arr[-- j] > arr[mid]);
            if(i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }

    // 冒泡排序 最好O(n)，最坏O(n^2) 空间复杂度：O(1) 稳定
    // 两两比较，把最大的冒泡到最后
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped = false;
        for(int i = 0; i < n - 1; i ++ ) {
            // 第一层循环是轮数
            for(int j = 0; j < n - i - 1; j ++ ) {
                // 第二层循环是数组中元素两两比较
                if(arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped = true;
                }
            }
            if(!swapped) {
                // 一轮中没有交换，说明全部有序
                return;
            }
        }
    }

    // 插入排序，时间复杂度最好O(n) 最坏O(n^2) 空间复杂度O(1) 稳定
    // 将元素插入到已经有序的元素中的合适位置
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++ ) {
            int cur = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > cur) {
                // 比arr[i]小的元素全部都往后移
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = cur;
        }
    }

    // 选择排序，时间复杂度O(n^2) 空间复杂度O(1)
    // 选择未排序中的最小放到，已排序元素的末尾
    // 不稳定，因为有交换 [4, 5, 3, 2, 4, 1]
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i ++ ) {
            int minid = i;
            for(int j = i + 1; j < n; j ++ ) {
                if(arr[j] < arr[minid]) {
                    minid = j;
                }
            }
            if(minid != i) {
                int t = arr[minid];
                arr[minid] = arr[i];
                arr[i] = t;
            }
        }
    }

    // 归并排序 时间复杂度O(logn)  空间复杂度O(n)（需要额外空间存储临时数组）
    // 将数组划分成左右两部分，递归进行归并排序后，再合并这两部分
    // 稳定
    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = left + right >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // 合并左右有序的数组
        int i = left, j = mid + 1;
        int[] tmp = new int[right - left + 1];
        int cur = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                tmp[cur ++] = arr[i ++];
            }else {
                tmp[cur ++] = arr[j ++];
            }
        }
        while(i <= mid) {
            tmp[cur ++] = arr[i ++];
        }
        while(j <= right) {
            tmp[cur ++] = arr[j ++];
        }
        cur = 0;
        for(int k = left; k <= right; k ++ ) {
            arr[k] = tmp[cur ++];
        }
    }
}
