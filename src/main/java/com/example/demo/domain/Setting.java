package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "settings")
@Getter
@Setter
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "settingCache")
public class Setting extends BaseModel {
    @Column(name = "_key", unique = true, nullable = false)
    private String key;

    @Lob
    @Column(name = "_value")
    private Serializable value;

}
