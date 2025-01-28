import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = ts.twoSum(nums1, target1);
        System.out.println("Indices: " + result1[0] + ", " + result1[1]);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = ts.twoSum(nums2, target2);
        System.out.println("Indices: " + result2[0] + ", " + result2[1]);

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = ts.twoSum(nums3, target3);
        System.out.println("Indices: " + result3[0] + ", " + result3[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        int sol[]=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                sol[0]=map.get(target-nums[i]);
                sol[1]=i;
                return sol;
            }
            map.put(nums[i],i);
        }
        return sol;
    }
}