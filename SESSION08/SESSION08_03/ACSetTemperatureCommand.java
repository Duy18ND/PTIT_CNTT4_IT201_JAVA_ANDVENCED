package SESSION08.SESSION08_03;

import SESSION08.SESSION08_03.Command;

class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.newTemp = temp;
    }

    public void execute() {
        prevTemp = ac.getTemperature(); // lưu trạng thái cũ
        ac.setTemperature(newTemp);
    }

    public void undo() {
        ac.setTemperature(prevTemp);
        System.out.println("Undo: Điều hòa: Nhiệt độ = " + prevTemp);
    }
}