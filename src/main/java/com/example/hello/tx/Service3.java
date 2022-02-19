package com.example.hello.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service3 {

    // default Propagation.REQUIRED มันจะดูว่ามี active transaction ไหมถ้ามีก็ใช้ของเดิม ถ้าไม่มีจะสร้างใหม่
    // ถ้าเกิดข้อผิดพลาดมันจะ roll back กลับไปหาตั้งแต่ active transaction แรก (ถูกเรียกจาก CLass อื่นเช่น service2)
    // Propagation.REQUIRES_NEW การจัดการขอบเขตของ transaction มันจะสร้างใหม่เสมอเพราะ ฉะนั้นหากเกิด error
    // มันจะไม่ roll back ไปอันก่อนหน้า
    // ขึ้นกับ business logic
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSth(){

    }
}
