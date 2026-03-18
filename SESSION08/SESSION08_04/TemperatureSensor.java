package SESSION08.SESSION08_04;

import java.util.*;

class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void attach(Observer o) {
        observers.add(o);
        System.out.println("Đã đăng ký observer");
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("\nCảm biến: Nhiệt độ = " + temp);
        notifyObservers();
    }
}