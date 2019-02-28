public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxPlus = nums [nums.length - 1];
        int maxMinus = nums [nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxPlus = nums [i] + Math.max(maxPlus, 0);
            maxMinus = Math.max(maxPlus, maxMinus);
        }
        return Math.max(maxPlus, maxMinus);
    }

    public int maxSubArray1(int[] nums) {
        int maxSum=nums[0],thisSum=nums[0];
        for(int i = 1; i < nums.length; i++){
            if(thisSum < 0) {
                thisSum = nums[i];
            } else {
                thisSum += nums[i];
            }
            if(thisSum > maxSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static void main(String arg[]) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};


        System.out.println(maxSubArray.maxSubArray1(nums));
    }
}
