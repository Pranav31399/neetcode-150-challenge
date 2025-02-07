import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ansMap=new HashMap<>();
        int count[]=new int[26];
        for(String str:strs){
            Arrays.fill(count,0);
            for(char c:str.toCharArray()){
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            ansMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(ansMap.values());
    }
}
