package pattern.proxy.jdk.sample1;

public class Student implements iStudent{
    @Override
    public void selfIntroduction() {
        System.out.println("我叫李华超");
        System.out.println("来自东南大学");
    }
}
