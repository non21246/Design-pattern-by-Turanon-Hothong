package Observer;

// อินเทอร์เฟซ Subject
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
