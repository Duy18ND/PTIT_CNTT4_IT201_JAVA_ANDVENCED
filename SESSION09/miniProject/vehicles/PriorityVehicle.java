package SESSION09.miniProject.vehicles;

import SESSION09.miniProject.intersection.Intersection;

public class PriorityVehicle extends Vehicle {
    public PriorityVehicle(String id, VehicleType type, int speed, Intersection intersection) {
        super(id, type, VehiclePriority.HIGH, speed, intersection);
    }

    @Override
    public boolean canPassOnRed() {
        return true;
    }
}

