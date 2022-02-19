package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // singleton
public class IdService {
    // IOC inversion of control : คนใช้เป็นคนเรียก ที่ทำแบบนี้เพราะ Spring จะช่วยให้ง่ายขึ้น

    // @Autowired ดึง instance ที่ถูกสร้างใน Spring container ความหมายคือ NumberGenerator ที่ถูก initial แล้ว
    // เอามาใช้ได้เลยไม่ต้องส่ง ทำให้ลบ main, setter ออกได้
    @Autowired
    private NumberGenerator numberGenerator;

//    public static void main(String[] args) {
//        NumberGenerator numberGenerator = new NumberGenerator();

//        // Contructor injection : ใช้เมื่อ numberGenerator ถูกใช้ในทุกๆ method
//        IdService idService = new IdService(numberGenerator);
//        // Setter injection
//        idService.setNumberGenerator(numberGenerator); // ใช้เมื่อไหร่ก็ได้ อยากใช้ก็ Set มันจะครึ่งๆกลางๆแต่ยืดหยุ่น
//        // Method injection
//        String id = idService.generate(numberGenerator); // ใช้แค่ใน method

//        IdService idService = new IdService();
//        idService.setNumberGenerator(numberGenerator); // Setter injection
//        String id = idService.generate();
//        System.out.println(id);
//    }

//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    public String generate() {
        String id = "HELLO" + numberGenerator.get();
        return id;
    }
}
