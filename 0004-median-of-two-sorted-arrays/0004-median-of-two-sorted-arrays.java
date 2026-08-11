class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int l=0,r=0,k=0;

        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] <= nums2[r]) {
                arr[k++] = nums1[l++];
            } else {
                arr[k++] = nums2[r++];
            }
        }

        while (l < nums1.length) {
            arr[k++] = nums1[l++];
        }

        while (r < nums2.length) {
            arr[k++] = nums2[r++];
        }

        if(arr.length%2!=0){
            return arr[arr.length/2];
        }

        return (arr[arr.length/2]+arr[arr.length/2-1])/2.0;
    }
}