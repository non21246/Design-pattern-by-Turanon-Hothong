# Design Pattern
## 1.Adapter Pattern
Adapter Pattern ทำงานโดยการสร้างอินเทอร์เฟซใหม่ที่ทำหน้าที่เป็นตัวกลางในการเชื่อมต่อระหว่างคลาสหรืออ็อบเจกต์ที่มีอินเทอร์เฟซที่แตกต่างกัน โดย Adapter จะถือหน้าที่แปลงการเรียกเมธอดหรือการทำงานจากอินเทอร์เฟซเดิมไปเป็นรูปแบบที่เข้ากับอินเทอร์เฟซใหม่ที่ต้องการ

### ภาพรวม
เรามีอินเทอร์เฟซสองตัวคือ
- **USB_CPort** กำหนดเมธอดสำหรับการชาร์จและการใช้งานพอร์ต USB-C
- **LightningPort** กำหนดเมธอดสำหรับการชาร์จและการใช้งานพอร์ต Lightning
นอกจากนี้ยังมีคลาส
- **IPhone** แทนอุปกรณ์ iPhone ที่ implement อินเทอร์เฟซ **LightningPort**

และยังมี Adapter Class คือ
- **LightningToTypeCAdapter** ทำหน้าที่แปลงอินเทอร์เฟซ **LightningPort** เป็น **USB_CPort** เพื่อให้อุปกรณ์ iPhone ทำงานกับพอร์ต USB-C

### Class Diagram
![Adapter Pattern Diagram](../master/src/img/Adapter.png)

### ตัวอย่าง
```java
// สร้างอ็อบเจกต์ iPhone
IPhone iPhone = new IPhone();

// สร้างอัดเพ็ปเตอร์เพื่อใช้งานพอร์ต USB-C กับ iPhone
USB_CPort adapter = new LightningToTypeCAdapter(iPhone);

// ใช้งานพอร์ต USB-C เพื่อชาร์จ iPhone
adapter.recharge();

// ใช้งานพอร์ต USB-C เพื่อถ่ายโอนข้อมูล
adapter.useUSB_C();
```

## 2.Builder Pattern
Builder Pattern เป็นแบบแผนการออกแบบที่ใช้ในการสร้างอ็อบเจกต์โดยที่เราสามารถกำหนดค่าและสร้างอ็อบเจกต์ขึ้นมาอย่างยืดหยุ่น โดยไม่ต้องเสียเวลาในการกำหนดค่าแต่ละอย่างโดยตรง และยังช่วยลดการสร้างอ็อบเจกต์ที่ซับซ้อนลงด้วย

### ภาพรวม
คลาส `House` มี attribute คือ
- ฐานราก (foundation)
- โครงสร้าง (structure)
- หลังคา (roof)
- การตกแต่ง (furnished)
เราใช้ Builder Pattern เพื่อสร้าง `House` โดยมีคลาส `Builder` เป็นภายในของ `House` เพื่อช่วยกำหนดค่าและสร้างอ็อบเจกต์ House ได้ง่ายและอ่านง่าย

### Class Diagram
![Builder Pattern Diagram](../master/src/img/Builder.png)

### ตัวอย่าง
```java
// สร้าง Builder
House.Builder builder = new House.Builder();

// กำหนดคุณสมบัติของบ้าน
House house = builder
    .foundation("Strong foundation")
    .structure("Solid structure")
    .roof("Durable roof")
    .furnished(true)
    .build();
```
ด้านล่างเป็นคำอธิบายของโค้ดที่ใช้ Command Pattern ซึ่งสามารถนำไปเพิ่มในไฟล์ README ของโปรเจกต์ได้:

---

## 3.Command Pattern

Command Pattern เป็นแบบแผนการออกแบบที่เป็นไปได้สำหรับการทำงานกับคำสั่งโดยที่สามารถแยกการสั่งงานจากการประมวลผลจริงได้อย่างมีประสิทธิภาพ และเป็นทางเลือกที่ดีเมื่อต้องการเพิ่มความยืดหยุ่นและลดการผูกพันกับโค้ด

### ภาพรวม 
ประกอบด้วยคลาสหลัก คือ
- TurnOnLightCommand คลาส Concrete Command ที่ใช้ในการเปิดไฟ
- TurnOffLightCommand คลาส Concrete Command ที่ใช้ในการปิดไฟ
- Light: คลาส Receiver ที่รับคำสั่งจาก Concrete Command เพื่อทำการเปิดหรือปิดไฟ
- Command อินเทอร์เฟซที่กำหนดเมธอด execute() เพื่อรับผิดชอบในการดำเนินการตามคำสั่ง
- RemoteControl คลาส Invoker ที่ใช้ในการกำหนดและเรียกใช้งานคำสั่ง
- 
### Class Diagram
![Command Pattern Diagram](../master/src/img/Command.png)

### ตัวอย่าง
```java
// สร้างคำสั่งเปิดและปิดไฟ
TurnOnLightCommand turnOnCommand = new TurnOnLightCommand(light);
TurnOffLightCommand turnOffCommand = new TurnOffLightCommand(light);

// กำหนดคำสั่งให้กับ RemoteControl
RemoteControl remoteControl = new RemoteControl();
remoteControl.setCommand(turnOnCommand);

// กดปุ่มเพื่อเปิดไฟ
remoteControl.pressButton();
```

## 4.Factory Pattern
Factory Method Pattern เป็นแบบแผนการออกแบบที่ช่วยให้เราสามารถสร้างอ็อบเจกต์ของคลาสต่างๆ โดยไม่จำเป็นต้องระบุคลาสโดยตรง และสามารถเปลี่ยนแปลงการสร้างอ็อบเจกต์ได้อย่างยืดหยุ่น

### ภาพรวม
ประกอบด้วยคลาส
- **Animal** คลาส Abstract ที่ระบุเมธอด `makeSound()` ซึ่งจะถูกบังคับให้ทุกคลาสที่สืบทอดมาจาก Animal ต้องมีเมธอดนี้
- **Dog** คลาสที่สืบทอดมาจาก Animal และระบุการทำเสียงของสุนัข
- **Cat** คลาสที่สืบทอดมาจาก Animal และระบุการทำเสียงของแมว
- **AnimalFactory** คลาสที่มีเมธอด `getAnimal()` เพื่อสร้างอ็อบเจกต์ของ Animal ตามประเภทที่กำหนด

### Class Diagram
![Factory Pattern Diagram](../master/src/img/Factory.png)

### ตัวอย่าง
```java
AnimalFactory animalFactory = new AnimalFactory();
Animal dog = animalFactory.getAnimal("Dog");
Animal cat = animalFactory.getAnimal("Cat");
System.out.println(dog.makeSound()); // Output: "Bark"
System.out.println(cat.makeSound()); // Output: "Meow"
```

## 5.Observer Pattern

Observer Pattern เป็นแบบแผนการออกแบบที่ช่วยให้คลาสหนึ่งสามารถแจ้งข้อมูลหรือสถานะให้กับอีกคลาสหนึ่งหรือหลายคลาสได้อย่างแยกต่างหาก โดยไม่ต้องรู้เกี่ยวกับคลาสที่ได้รับข้อมูล

### ภาพรวม
ประกอบด้วยคลาส
- **Subject** อินเทอร์เฟซที่กำหนดเมธอด `registerObserver()`, `removeObserver()`, และ `notifyObservers()` เพื่อการจัดการกับ Observer
- **Observer**: อินเทอร์เฟซที่ระบุเมธอด `update()` เพื่อรับข้อมูลหรือสถานะจาก Subject
- **NewsAgency**: คลาสที่รับผิดชอบในการจัดการ Observer และการแจ้งข้อมูลหรือสถานะให้กับ Observer
- **NewsChannel**: คลาสที่รับข้อมูลหรือสถานะจาก Subject และดำเนินการตามที่กำหนดในเมธอด `update()`

### Class Diagram
![Observer Pattern Diagram](../master/src/img/Observer.png)

### ตัวอย่าง
```java
// สร้าง Subject (NewsAgency)
NewsAgency newsAgency = new NewsAgency();

// สร้าง Observer (NewsChannel)
NewsChannel newsChannel = new NewsChannel();
newsAgency.registerObserver(newsChannel);
newsAgency.setNews("Breaking News: COVID-19 vaccine rollout begins!");
```

# Proxy Pattern

Proxy Pattern เป็นแบบแผนการออกแบบที่ช่วยให้เราสามารถควบคุมการเข้าถึงหรือใช้งานวัตถุต้นฉบับ (Real Object) ได้ โดย Proxy Object จะทำหน้าที่คอยติดต่อกับ Real Object และจัดการกับการเข้าถึงวัตถุต้นฉบับให้ตรงตามที่กำหนด

### ภาพรวม
ประกอบด้วยคลาส
- **Image** อินเทอร์เฟซที่ระบุเมธอด `display()` เพื่อแสดงภาพ
- **RealImage** คลาสที่เป็น Real Object ซึ่งรับผิดชอบในการโหลดและแสดงภาพจริง
- **ProxyImage** คลาสที่เป็น Proxy Object ซึ่งทำหน้าที่คอยติดต่อกับ Real Image และจัดการการเข้าถึง Real Image

### Class Diagram
![Proxy Pattern Diagram](../master/src/img/Proxy.png)

```java
// สร้าง ProxyImage
Image image = new ProxyImage("example.jpg");

// เรียกใช้งานเมธอด display() ผ่าน ProxyImage
image.display();
```
