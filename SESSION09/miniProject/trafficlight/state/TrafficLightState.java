package SESSION09.miniProject.trafficlight.state;

import SESSION09.miniProject.trafficlight.TrafficLightColor;

public interface TrafficLightState {
    TrafficLightColor color();

    TrafficLightState next();
}

