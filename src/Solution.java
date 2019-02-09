import java.math.BigInteger;

class Solution {
    public  static void main(String arg[]){
        //int[] nums = {-1,-1,-1,0,1,1};
        //int result = pivotIndex(nums);
        //System.out.print(result);


        String s = "10100000100100110110010000010101111011011001101110111111111101000000";
        String sum = addBinary("1010","1011");
        System.out.print(sum);



    }


        public static String addBinary(String a, String b) {
            BigInteger decimal_a = new BigInteger(a, 2);
            BigInteger decimal_b = new BigInteger(b, 2);
            //Long decimal_a = Long.parseLong(a,2);
            //Long decimal_b = Long.parseLong(a,2);
            BigInteger sum = decimal_a.add(decimal_b);
            String s = sum.toString(2);
            return s;
        }



    public static int pivotIndex(int[] nums) {
        for (int n = 0; n < nums.length; ++n) {
            int sum_left = 0;
            int sum_right = 0;
            for(int i=0; i<n; i++) {
                sum_left=sum_left+nums[i];
            }
            for(int i=n+1; i<nums.length; i++) {
                sum_right=sum_right+nums[i];
            }
            if (sum_left == sum_right) return n;
        }
        return -1;
    }
}