public class IncreasingSequence {

    // when we just need to find the length of increasing subsequence

    public static void main(String[] args) {
        int[] arr = {2,4,10,3,4,4,5};
        System.out.println(findLengthStrictly(arr));

        System.out.println(findLengthNonStrictly(arr));

        int[] sortedArr = {2,3,4,7,8,9};
        System.out.println(findPosUpperBound(sortedArr,5,4));
    }

    //strictly
    private static int findLengthStrictly(int[] arr){

        int[] maxLength = new int[arr.length+1];

        int index = 0;
        maxLength[0] = Integer.MIN_VALUE;
        for(int num:arr) {

            if(num > maxLength[index]){
                index++;
                maxLength[index] = num;
            }
            else{
                int pos = findPos(maxLength, index, num);
                maxLength[pos] = num;
            }

        }

        return index;
    }
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
    // / //////////////


    // / ///////////for not strictly
    private static int findLengthNonStrictly(int[] arr){

        int[] maxLength = new int[arr.length+1];

        int index = 0;
        maxLength[0] = Integer.MIN_VALUE;
        for(int num:arr) {

            if(num > maxLength[index]){
                index++;
                maxLength[index] = num;
            }
            else{
                int pos = findPosUpperBound(maxLength, index, num);
                if(pos > index){
                    index = pos;
                }
                maxLength[pos] = num;
            }

        }

        return index;
    }

    private static int findPosUpperBound(int[] arr, int index, int num){
        int left = 0;
        int right = index+1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] >= num){
                right = mid;
            }
            else{
                left = mid+1;
            }

        }
        return left-1;
    }




}
