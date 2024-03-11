package Adapter;

public class Adapter {
    public static void main(String[] args) {
        LightningPort iPhone = new IPhone();

        LightningToTypeCAdapter adapter = new LightningToTypeCAdapter(iPhone);

        adapter.recharge();
        adapter.useUSB_C();
    }
}
