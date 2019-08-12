package solution.牛客部分题二刷;

public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return new String();
        }
        int p1 = str.length() - 1;
        //1.根据空格数目，扩充StringBuffer
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 < p2 && p1 >=0 && p2 >= 0) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
