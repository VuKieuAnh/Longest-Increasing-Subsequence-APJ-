import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void lengthOfLIS(int[] arr) {
        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LIS.add(new ArrayList<>());
        }
        LIS.get(0).add(arr[0]);

        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                //arr[j] < arr[i] số trước nhỏ hơn số hiện tại
                //LIS.get(j).size() > LIS.get(i).size() mảng  thứ j có kích thước lớn hơn mảng thứ i
                if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    //
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(arr[i]);
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }

        System.out.print(LIS.get(j));
    }

    public static void main(String[] args) {
        int[] a = {100, 2, 9,33,21, 50, 41, 9, 80};
        lengthOfLIS(a);
    }

    public static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        for (int n1:list
             ) {
            System.out.println(n1);
        }
        return list.size();
    }

    public static int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return list.get(start) >= target ? start : end;
    }
}
