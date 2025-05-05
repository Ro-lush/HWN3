package ex8;

// Жесткая зависимость (нарушение DIP)
class DatabaseConnection implements IDatabase {
    public boolean isConnected() {
        return true;
    }


    public void save(Employee emp) {
    }
}
