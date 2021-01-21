package ee.bcs.valiit.tasks;

public class Test {

    public String name;
    private String address;
    private int age;
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public Test setName (String name) {
        this.name = name;
        return this;
   }

    public String getAddress() {
        return address;
    }
    public Test setAddress(String address){
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Test setAge() {
        return this;
    }
}
