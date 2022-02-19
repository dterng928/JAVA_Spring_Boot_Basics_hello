package com.example.hello;

//Throwable => ใน spring จะมีตัว rest controller advice ซึ่งมันจะดักได้แค่พวกที่เป็น runtime เราเลยต้องเปลี่ยนเป็น RuntimeException
//public class UserNotFoundException extends Throwable {
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super(name);
    }
}
