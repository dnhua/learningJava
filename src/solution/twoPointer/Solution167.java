package solution.twoPointer;

/**
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution167 {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    //二分查找
    //high：寻找比target小，但是其右边比target大的坐标
    //low：寻找比target大，但是左边比target小的坐标
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low < high) {
            if((numbers[low] + numbers[high]) > target) {
                int start = low+1;
                int end = high;
                while(start < end) {
                    int mid = (start+end)/2;
                    if((numbers[low] + numbers[mid]) > target) {
                        end = mid-1;
                    }else if((numbers[low] + numbers[mid]) < target) {
                        start = mid+1;
                    }else{
                        end = mid;
                        break;
                    }
                }
                if((numbers[low] + numbers[end]) > target) end--;
                high = end;
            }else if((numbers[low] + numbers[high]) < target) {
                int start = low;
                int end = high-1;
                while(start < end) {
                    int mid = (start+end)/2;
                    if((numbers[high] + numbers[mid]) > target) {
                        end = mid-1;
                    }else if((numbers[high] + numbers[mid]) < target) {
                        start = mid+1;
                    }else{
                        end = mid;
                        break;
                    }
                }
                if((numbers[end] + numbers[high]) < target) end++;
                low = end;
            }else{
                break;
            }
        }
        return new int[]{low+1, high+1};
    }
}
