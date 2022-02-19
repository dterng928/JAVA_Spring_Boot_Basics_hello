package com.example.hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// ที่ไม่ต้องใส่ @Component, @Service เพราะเราใช้ JpaRepository ซึ่งเป็นของ Spring boot แล้วมันประกาศไว้ให้
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}
