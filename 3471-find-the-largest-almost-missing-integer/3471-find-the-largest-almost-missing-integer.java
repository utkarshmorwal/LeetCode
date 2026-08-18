class Solution {
  
    public static int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return n;
        // Case 2, find maximum num
        if(n == k) {
            int max = nums[0];
            for(int num:nums)
                max = Math.max(max,num);
            return max;
        }
        // Case 3, find maximum with freq 1
        int[] freq = new int[51];
        for(int c : nums) 
            freq[c]++;
        if(k == 1) {
            int max=-1;
            for(int c : nums) {
                if(freq[c] == 1) max = Math.max(max, c);
            }
            return max;
        }
        // Check if they appear once
        if(nums[0] == nums[n-1]) return -1;

        int first=nums[0];
        int last=nums[n-1];

        if(freq[first]==1 && freq[last] ==1) return Math.max(first,last);
        if(freq[first]==1 ) return first;
        if(freq[last]==1 ) return last;

        return -1;
    }
}