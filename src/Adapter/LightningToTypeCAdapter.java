package Adapter;

// อแดปเตอร์ที่ทำให้ iPhone สามารถใช้งานผ่าน USB_CPort
public class LightningToTypeCAdapter implements USB_CPort {
    private LightningPort lightningDevice;

    public LightningToTypeCAdapter(LightningPort lightningDevice) {
        this.lightningDevice = lightningDevice;
    }

    @Override
    public void recharge() {
        if (lightningDevice == null) {
            System.out.println("No Lightning device connected.");
            return;
        }
        lightningDevice.recharge();
    }

    @Override
    public void useUSB_C() {
        if (lightningDevice == null) {
            System.out.println("No Lightning device connected.");
            return;
        }
        System.out.println("Converting to USB-C...");
        lightningDevice.useLightning();
    }
}


