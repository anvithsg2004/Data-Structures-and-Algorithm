import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : list) {

            if (k == 0) {
                break;
            }

            int number = entry.getKey();

            result.add(number);

            k--;

        }

        int[] finalResult = new int[result.size()];

        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;

    }
}
