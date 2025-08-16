//https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

class Solution {
    public String findLargest(int[] arr) {
        String[] nums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
        if (nums[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }
        
        return result.toString();
    }
}
