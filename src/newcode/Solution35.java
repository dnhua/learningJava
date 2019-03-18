package newcode;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍
 * 历的结果。如果是则输出Yes,否则输出No。假设输入的数组的
 * 任意两个数字都互不相同。
 */
public class Solution35 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        verify(sequence, 0, sequence.length - 1);
        return false;
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootval = sequence[last];
        //找到第一个大于rootval值的位置
        int i = first;
        for (; i < last; i++) {
            if (sequence[i] > rootval)
                break;
        }
        int cutIndex = i;
        while (i < last) {
            if (sequence[i] < rootval)
                return false;
            i++;
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}

//    public boolean VerifySquenceOfBST(int[] sequence) {
//        if (sequence == null || sequence.length == 0)
//            return false;
//        return verify(sequence, 0, sequence.length - 1);
//    }
//
//    private boolean verify(int[] sequence, int first, int last) {
//        if (last - first <= 1)
//            return true;
//        int rootVal = sequence[last];
//        int cutIndex = first;
//        while (cutIndex < last && sequence[cutIndex] <= rootVal)
//            cutIndex++;
//        for (int i = cutIndex; i < last; i++)
//            if (sequence[i] < rootVal)
//                return false;
//        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
//    }
