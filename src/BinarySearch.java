public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,3,6,8,8,8,10,12};
        System.out.println(findPos(arr, 5, 8));
    }


    // lower bound when first >= .....right=mid-1, left = mid
    // upper bound when first > .......right =mid, left = mid+1

    private static int findPos(int[] arr, int index, int num){

        int left = 0;
        int right = index;

        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] >= num){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

}
