package cn.study.entity;

public class Window {
    public static void main(String[] args) {
        PersonSon ps = new PersonSon();
        ps.setId(5);
        ps.setEmail("abc@qq.com");
        System.out.println(ps.toString());
        System.out.println(ps instanceof Person);
        System.out.println(ps instanceof PersonSon);


        Person person = new Person(4, "abcd", "d", 2);
        System.out.println(person);




    }


}
