class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;

        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2;          // partition in nums1
            int j = halfLen - i;             // partition in nums2

            int Aleft  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int Bleft  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if we have a valid split
            if (Aleft <= Bright && Bleft <= Aright) {
                // Found correct partition
                if ((m + n) % 2 == 1) {
                    // Odd total length → max of left halves
                    return Math.max(Aleft, Bleft);
                } else {
                    // Even total length → average of max left and min right
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                // Too far right in nums1, move left
                high = i - 1;
            } else {
                // Too far left in nums1, move right
                low = i + 1;
            }
        }

        // Should never reach here if inputs are valid and sorted
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
    
}
