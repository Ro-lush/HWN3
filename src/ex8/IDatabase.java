package ex8;

public interface IDatabase {
    boolean isConnected();
    void save(Employee emp);
}
