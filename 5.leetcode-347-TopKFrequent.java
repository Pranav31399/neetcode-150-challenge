import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent2(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        int[] ans = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll().getKey();
            if(i==k)
                break;
        }
        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        if(k==nums.length)
            return nums;

        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a)-map.get(b)
        );

        for(int num:map.keySet()){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=heap.poll();
        }
        return ans;
    }
}
