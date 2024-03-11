package Adapter;

public class IPhone implements LightningPort {
    @Override
    public void recharge() {
        System.out.println("Recharging iPhone...");
    }

    @Override
    public void useLightning() {
        System.out.println("Using Lightning Port...");
    }
}
