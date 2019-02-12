
public class BinarySearch {

    private int binSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }


    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length -1;
        while (right > left) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) left = mid +1;
            if (target < nums[mid]) right = mid;
        }
        if (target == nums[left]) return left;
        else return -1;
    }

    public  static void main(String arg[]) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {5, 6, 7, 8,9,10};
        int target = 10;

        System.out.println(binarySearch.binSearch(nums, target));

    }
}
