package SESSION08.SESSION08_04;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}