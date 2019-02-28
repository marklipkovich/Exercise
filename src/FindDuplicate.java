public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums [i] ==nums [j]) return nums [i];
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])]<0){
                return Math.abs(nums[i]);
            }
            else{
                nums[Math.abs(nums[i])]*=-1;
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(slow!=fast);
        slow = 0;
        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public  static void main(String arg[]) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums = {1,3,4,2,1};

        System.out.println(findDuplicate.findDuplicate2(nums));

    }
}
