public class SearchRange {
    private int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int midInd;
        int min = 0;
        int rangeMin;
        int rangeMax;
        int max = nums.length -1;
        while (max > min) {
            midInd = min + (max - min) / 2;
            if (nums[midInd] == target) {
                rangeMin = midInd ;
                rangeMax = midInd;
                while ( (rangeMin > 0) && (nums[rangeMin - 1] == target)){
                    rangeMin = rangeMin -1;
                }
                while ((rangeMax < nums.length -1) && (nums[rangeMax +1] == target)) {
                    rangeMax = rangeMax +1;
                }
                res [0] = rangeMin;
                res [1] = rangeMax;
                return res;

            }
            if (nums[midInd] < target) min = midInd +1;
            if (nums[midInd] > target) max = midInd;
        }
        if (target == nums[max]) {
            res [0] = max;
            res [1] = max;
        }
        return res;
    }

    public  static void main(String arg[]) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {1,2, 6, 6};
        int target = 6;
        int [] res = searchRange.searchRange(nums, target);
        System.out.println(res [0]+ ","+ res [1]);

    }
}
