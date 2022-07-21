package com.cybertester.entity.standardCalc;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "DX_REGISTR", schema = "FSBS")
public class StandardDxRegistrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECORD_UQ")
    long recordUq;

    @Column(name = "GUID_INPUT")
    String guidInput;

    @Override
    public String toString() {
        return "StandardDxRegistrEntity{" +
                "recordUq=" + recordUq +
                ", guidInput='" + guidInput + '\'' +
                '}';
    }
}
