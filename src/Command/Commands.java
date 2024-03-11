package Command;

public class Commands {
    public static void main(String[] args) {
        // สร้าง Receiver (Light)
        Light light = new Light();

        // สร้าง Concrete Command และกำหนด Receiver (Light)
        TurnOnLightCommand turnOnCommand = new TurnOnLightCommand(light);
        TurnOffLightCommand turnOffCommand = new TurnOffLightCommand(light);

        // สร้าง Invoker (RemoteControl) และกำหนดคำสั่งที่ต้องการ
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnCommand);

        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);

        remoteControl.pressButton();
    }
}
