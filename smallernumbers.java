class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] count = new int[101]; // The problem statement specifies that nums[i] is between 0 and 100
        
        // Count occurrences of each number in nums
        for (int num : nums) {
            count[num]++;
        }
        
        // Calculate the count of numbers smaller than each number
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        
        // Calculate the result array based on the count array
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            result[i] = num == 0 ? 0 : count[num - 1];
        }
        
        return result;
    }
}
