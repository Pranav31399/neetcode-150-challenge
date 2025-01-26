import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 1, 2, 3, 1 };

        System.out.println(containsDuplicate3(nums1)); // Output: false
        System.out.println(containsDuplicate3(nums2)); // Output: true
    }

    // Solution 1 : Brute Force - Time Complexity: O(n^2)
    public static boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // Solution 2 : Sorting, Time Complexity: O(nlogn)
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    // Solution 3 : Hash Set, Time Complexity: O(n)
    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if (seenNumbers.contains(num))
                return true; // duplicate found
            seenNumbers.add(num);
        }
        return false;
    }
}