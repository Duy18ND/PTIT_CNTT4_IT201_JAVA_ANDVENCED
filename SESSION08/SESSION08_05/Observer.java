package SESSION08.SESSION08_05;

import java.util.*;

interface Observer {
    void update(int temperature);
}

class TemperatureSensor {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("\nCảm biến: Nhiệt độ = " + temp);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}