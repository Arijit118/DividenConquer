package DividenConquer;

public class AssignmentQTwo {
    public static int majorityElement(int nums[]) {
        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int majorityElementRec(int nums[], int si, int ei) {
        // base case
        if (si == ei) {
            return nums[si];
        }

        // calculate mid
        int mid = si + (ei - si) / 2;

        // find majority element in left and right part of the array
        int left = majorityElementRec(nums, si, mid);
        int right = majorityElementRec(nums, mid + 1, ei);

        // if the two halves agree on the majority element, return it
        if (left == right) {
            return left;
        }

        // otherwise, count in left part and right part and return the winner
        int leftCount = countInRange(nums, left, si, ei);
        int rightCount = countInRange(nums, right, si, ei);

        return leftCount > rightCount ? leftCount : rightCount;
    }

    public static int countInRange(int nums[], int num, int si, int ei) {
        int count = 0;

        for (int i = si; i <= ei; i++) {
            if (nums[i] == num) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        /*
         * Given an array nums of size n, returnthe majority element.
         * (MEDIUM)The majority element is the element that appears more than ⌊n/2⌋
         * times.
         * You may assume that the majority element always exists in the array.Sample
         * Input
         * 1: nums = [3,2,3] Sample Output 1: 3
         * Sample Input 2: nums =
         * [2,2,1,1,1,2,2] Sample Output 2: 2
         * Constraints(extra Conditions):
         * ●n ==nums.length
         * ●1 <= n <= 5 * 104
         * ●-109 <= nums[i] <= 109
         */
        // Brute force approach. Time complexity O(n^2).
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));

        // Approach2 Divide & conquer. Time complexity- O(n*logn).
        System.out.println(majorityElementRec(nums, 0, nums.length - 1));
    }
}
