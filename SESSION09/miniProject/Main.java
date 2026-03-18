package SESSION09.miniProject;

import SESSION09.miniProject.intersection.Intersection;
import SESSION09.miniProject.control.TrafficControl;
import SESSION09.miniProject.simulation.SimulationEngine;
import SESSION09.miniProject.trafficlight.TrafficLight;
import SESSION09.miniProject.vehicles.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        TrafficControl monitor = new TrafficControl();
        Intersection intersection = new Intersection(
                "Ngã tư A",
                200,
                25,
                1,
                monitor
        );

        TrafficLight light = new TrafficLight(
                6, // green
                2, // yellow
                6  // red
        );

        VehicleFactory factory = new VehicleFactory(intersection);
        SimulationEngine engine = new SimulationEngine(light, intersection, factory, monitor);

        engine.runForSeconds(25, 60);
    }
}

