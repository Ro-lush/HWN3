package ex8;

class Manager extends Employee {
    public Manager(int _id, String _name, String _email) {
        super(_id, _name, _email);
    }


    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
