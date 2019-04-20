package pattern.proxy.jdk.sample1;

public class test {
    public static void main(String[] args) {
        JdkStudentProxy studentProxy = new JdkStudentProxy();
        iStudent student = (iStudent) studentProxy.bind(new Student());
        student.selfIntroduction();
    }
}
