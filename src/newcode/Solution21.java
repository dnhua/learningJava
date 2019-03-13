package newcode;


import org.junit.jupiter.api.Test;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 */
public class Solution21 {

    //这种解法偶数的顺序会变
    public void reOrderArray1(int [] array) {
        int i = 0;
        int j = 0;
        while (i!=array.length && j!=array.length) {
            if (array[i]%2 == 0) {  //是偶数
                while (array[j++]%2==1) ;
                swap(array, i, j);
                i = j-1;
            }
            i++;
            j++;
        }
    }

    public void reOrderArray2(int [] array) {
        //首先统计有多少个奇数
        int oddnum = 0;
        for (int num : array) {
            if (num % 2 == 1) {
                oddnum++;
            }
        }
        int[] copy = array.clone();
        int i = 0, j = oddnum;
        for (int num : copy) {
            if (num % 2 == 1)
                array[i++] = num;
            else
                array[j++] = num;
        }
    }

    @Test
    public void test1() {
        int[] array = new int[]{1,2,3,4,5};
        //System.out.println(array);
        reOrderArray1(array);
        for (int num:array) {
            System.out.println(num);
        }
    }

    @Test
    public void test2() {
        int[] array = new int[]{1,2,3,4,5};
        //System.out.println(array);
        reOrderArray2(array);
        for (int num:array) {
            System.out.println(num);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tem = array[i];
        array[i] = array[j];
        array[j] = tem;
    }
}
