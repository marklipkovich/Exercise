public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums [i] ==nums [j]) return nums [i];
            }
        }
        return -1;
    }

    public  static void main(String arg[]) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums = {1,6,3,8,9,10,7,1};

        System.out.println(findDuplicate.findDuplicate(nums));

    }
}
