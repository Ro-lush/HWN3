package ex8;

// Нарушение LSP (неправильная иерархия)+
class Employee implements ISalaryEmployee,IEmailEmployee {
    private int id;
    private String name;
    private int age;
    private String email;
    private double salary;

    public Employee(int _id, String _name, String _email) {
        this.id = _id;
        this.name = _name;
        this.email = _email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String getEmail() {
        return email;
    }

    public void setAge(int _age) {
        this.age = _age;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double _salary) {
        if (_salary < 5000) {
            throw new IllegalArgumentException("Manager salary too low");
        }
        this.salary = _salary;
    }


}
