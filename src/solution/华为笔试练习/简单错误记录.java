package solution.华为笔试练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class 简单错误记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String messageLine = null;
        //使用有序的LinkedHashMap存储信息
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        //循环读入数据
        while ((messageLine = bufferedReader.readLine()) != null){
            String[] error_Message = messageLine.split(" ");
            String error = error_Message[0];
            String line_no = error_Message[1];
            //取文件名
            String file_Name = error.substring(error.lastIndexOf("\\") + 1);
            //处理长度超过16的情况
            if(file_Name.length() > 16){
                file_Name = file_Name.substring(file_Name.length() - 16);
            }

            //将错误信息添加到map中
            String error_Name = file_Name+" "+line_no;
            if (map.containsKey(error_Name)){
                map.put(error_Name,map.get(error_Name)+1);
            } else {
                map.put(error_Name,1);
            }
        }

        //输出错误信息,最多8条(后八条)
        int count = 0;
        for (String key:map.keySet()){
            count++;
            if(count > (map.size() -8))
                System.out.println(key + " " + map.get(key));
        }
    }
}
