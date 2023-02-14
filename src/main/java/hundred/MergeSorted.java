package hundred;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: hxl
 * @create: 2023-02-13 15:42
 **/
public class MergeSorted {

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before sorting: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(array.length);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] arry, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort(arry, start, mid);
            mergeSort(arry, mid + 1, end);
            merge(arry, start, end, mid);
        }
    }

    public static void merge(int[] arry, int start, int end, int mid) {
        //将数组划分成两个序列 比较i和j序列的值，new一个存储空间存储，将较小值存储到新的数组内，并移动数组下标
        int[] temp = new int[end - start + 1];
        int i_start = start;
        int i_end = mid;
        int j_start = mid + 1;
        int j_end = end;
        int len = 0;
        while (i_start <= i_end && j_start <= j_end) {
            if (arry[i_start] < arry[j_start]) {
                temp[len] = arry[i_start];
                i_start++;
                len++;
            } else if (arry[i_start] > arry[j_start]) {
                temp[len] = arry[j_start];
                j_start++;
                len++;
            }
        }

        //i j两个序列还剩下元素放在最后
        while (i_start <= i_end) {
            temp[len] = arry[i_start];
            len++;
            i_start++;
        }
        while (j_start <= j_end) {
            temp[len] = arry[j_start];
            len++;
            j_start++;
        }

        //将存储空间值覆盖到arry
        for (int i = 0; i < temp.length; i++) {
            arry[start+i] = temp[i];
        }
    }
}
