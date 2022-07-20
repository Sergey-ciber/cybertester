package com.cybertester.entity.testCalc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "test_docs_list", schema = "public")
public class TestDocsListEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "record_uq")
    private Long recordUq;

    @Column(name = "guid_input")
    String guidInput;

    @Column(name = "do_check")
    boolean doCheck;

    @Column(name = "record_uq_registr")
    long recordUqRegistr;
}
