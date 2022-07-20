package com.cybertester.entity.testCalc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "test_docs_list", schema = "public")
public class TestCalcCheckListEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "guid_input")
    String guidInput;

    @Column(name = "do_check")
    int doCheck;

    @Column(name = "record_uq_registr")
    long recordUqRegistr;

    @Column(name = "calc_result")
    int calcResult;

    @Column(name = "message")
    String message;

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
