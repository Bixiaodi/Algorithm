import java.io.*;
import java.util.Scanner;

public class Main {
    public static int partition(int[] num, int left, int right, int pivot) {
        int val = num[pivot], storeId = left;
        swap(num, pivot, right);
        for(int i = left; i < right; i++) {
            if(num[i] < val)
                swap(num, i, storeId++);
        }
        swap(num, storeId, right);
        return storeId;
    }
    public static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static int search(int[] num, int left, int right, int target) {
        if(left > right)
            return -1;
        int pivot = left + (right - left) / 2;
        pivot = partition(num, left, right, pivot);
        if(num[pivot] == target)
            return pivot + 1;
        if(num[pivot] < target)
            return search(num, pivot + 1, right, target);
        else
            return search(num, left, pivot - 1, target);

    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        int id= search(num, 0, n - 1, k);
        System.out.println(id);

    }
}