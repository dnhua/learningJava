package solution.牛客部分题二刷;

public class 数组中重复的数字 {
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        if (numbers == null || numbers.length == 0)
            return false;
        for (int i=0; i<numbers.length; i++) {
            while (i != numbers[i]) {
                if (numbers[numbers[i]] == numbers[i]) {    //这个条件是关键
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return false;
    }

    public void swap(int[] numbers, int i, int j) {
        int tem = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tem;
    }
}
