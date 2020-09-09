public class Employee {
    String name;
    String position;
    int age;
    int height;
    int pay;

    public Employee(String name, String position, int age, int height, int pay) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.pay = pay;
    }
    public void printEmployee(){
        System.out.println(name);
        System.out.println(position);
        System.out.println(age);
        System.out.println(height);
        System.out.println(pay);
    }
}
