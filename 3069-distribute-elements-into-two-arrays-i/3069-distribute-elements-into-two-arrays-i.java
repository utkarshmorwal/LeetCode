class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
   
        ans[0]=nums[0];
        nums[0]=0;
        int last=nums[1];
        int pointer=0;

        for(int i=2;i<nums.length;i++){
            if(ans[pointer]>last) {
                ans[++pointer]=nums[i];
                nums[i]=0;    
            }
            else last=nums[i];
        }

        for(int num:nums){
            if(num!=0) {
                ans[++pointer]=num;
            }
        }

        return ans;
    }
}