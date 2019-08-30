package solution.华为笔试练习;

import java.util.Scanner;

public class 汽水瓶 {
    public static int result(int n){
        int result = 0;
        int total = n;
        while(total>0){//不断循环
            if(total==2){//只剩下两瓶就+1
                total++;
            }
            total = total -3;
            if(total>=0){//每减三瓶总数加一瓶，结果也加一
                total++;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num==0)break;
            System.out.println(result(num));
        }
    }
}
