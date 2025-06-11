class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==1) return nums[0];
        int []dp1=new int[l-1];
        int []dp2=new int[l];
        dp1[0]=nums[0]; 
        dp1[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<l-1;i++){
            dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }
        dp2[0]=nums[1]; 
        dp2[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<l;i++){
            dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }
        return Math.max(dp1[l-2],dp2[l-1]);
    }
}