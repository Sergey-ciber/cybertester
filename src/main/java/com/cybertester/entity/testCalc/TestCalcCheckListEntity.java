package com.cybertester.entity.testCalc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "calc_check_list", schema = "public")
public class TestCalcCheckListEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "guid_input")
    private String guidInput;

    @Column(name = "do_check")
    private int doCheck;

    @Column(name = "record_uq_registr")
    private long recordUqRegistr;

    @Column(name = "calc_result")
    private int calcResult;

    @Column(name = "message")
    private String message;

    @Override
    public String toString() {
        return "TestDocsListEntity{" +
                "id=" + id +
                ", guidInput='" + guidInput + '\'' +
                ", doCheck=" + doCheck +
                ", recordUqRegistr=" + recordUqRegistr +
                '}';
    }
}
