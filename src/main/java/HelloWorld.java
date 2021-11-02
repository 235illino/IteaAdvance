import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {


    public static void main(String[] args) {
        int[] nums = {96, 1, 45, 33, 0, 8};
//        System.out.println(binar(69,nums,0,nums.length-1));
//        System.out.println((Arrays.toString(sortVyborom(nums))));
  //      System.out.println((Arrays.toString(sortVstavka(nums))));

        int a = 8;
        Integer b = 8;

        System.out.println(a == b);
        System.out.println(b == a);
        System.out.println(b.equals(a));


        System.out.println();

        Integer c = new Integer(50);
        int l = 50;

        double aD = 0.0;
        float aF = 0.0F;

        System.out.println(aD == aF);

        System.out.println(c.equals(l));

        System.out.println();

    }

    static int binar(int key, int[] nums, int firstIndex, int lastIndex) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (firstIndex > lastIndex) {
            throw new IllegalArgumentException();
        }

        int mid = firstIndex + (lastIndex - firstIndex) / 2;

        if (nums[mid] > key) {
            return binar(key, nums, firstIndex, mid - 1);
        }
        if (nums[mid] < key) {
            return binar(key, nums, mid + 1, lastIndex);
        }
        return mid;
    }

    static int[] sortVyborom(int[] nums) {
        int minInd;

        for (int i = 0; i < nums.length; i++) {
            minInd = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    minInd = j;
                }
            }

            if (minInd != i) {
                int temp = nums[i];
                nums[i] = nums[minInd];
                nums[minInd] = temp;
            }
        }
        return nums;
    }

    static int[] sortVstavka(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
            }
        }

                                                               return nums;
    }
}
