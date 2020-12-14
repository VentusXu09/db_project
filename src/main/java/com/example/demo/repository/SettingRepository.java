package com.example.demo.repository;

import com.example.demo.domain.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    Setting findByKey(String key);
}
