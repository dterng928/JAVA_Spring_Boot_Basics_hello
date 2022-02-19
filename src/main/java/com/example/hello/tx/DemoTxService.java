package com.example.hello.tx;

import com.example.hello.User;
import com.example.hello.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// @Transactional ครอบที่ class ทำให้ทุก method มี @Transactional หรือเราสามารถระบุทีละ method ก็ได้
public class DemoTxService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Service2 service2;

    @Autowired
    private Service3 service3;

    public void callRepository() {
        service2.doSth();
        service3.doSth();
    }

    private void processLongRunning() {
    }

    @Transactional
    public void step1() {
        User user1 = new User(1, "User 1");
        User user2 = new User(2, "User 2");
        User user3 = new User(3, "User 3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Transactional
    public void step2() {
        User user3 = new User(3, "User 3");

        userRepository.save(user3);
        userRepository.save(user3);
        userRepository.save(user3);
    }
}
