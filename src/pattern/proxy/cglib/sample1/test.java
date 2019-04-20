package pattern.proxy.cglib.sample1;

public class test {
    public static void main(String[] args) {
        CglibStudentProxy cgl = new CglibStudentProxy();
        Student student = (Student) cgl.getProxy(Student.class);
        student.selfIntroduction();
    }
}
