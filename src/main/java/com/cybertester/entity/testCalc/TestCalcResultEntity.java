package com.cybertester.entity.testCalc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "test_calc_result", schema = "public")
public class TestCalcResultEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "record_uq")
    private Long recordUq;

    @Column(name = "period_beg_day")
    private String periodBegDay;

    @Column(name = "period_end_day")
    private String periodEndDay;

    @Column(name = "price")
    private double price;

    @Column(name = "record_uq_registr", nullable=true)
    private Long recordUqRegistr;

    @Column(name = "period_percent")
    private int periodPercent;

    @Column(name = "prices_percent")
    private double pricesPercent;

    @Column(name = "count_days")
    private double countDays;

    @Column(name = "summa")
    private double summa;

    @Column(name = "record_uq_alce_type")
    private int recordUqAlceType;

    @Column(name = "record_uq_bcc")
    private int recordUqBCC;

    @Column(name = "year_calc")
    private int yearCalc;

    @Override
    public String toString() {
        return "TestCalcResultEntity{" +
                "id=" + id +
                "record_uq=" + recordUq +
                ", periodBegDay='" + periodBegDay + '\'' +
                ", periodEndDay='" + periodEndDay + '\'' +
                ", price=" + price +
                ", recordUQRegister=" + recordUqRegistr +
                ", periodPercent=" + periodPercent +
                ", pricesPercent=" + pricesPercent +
                ", countDays=" + countDays +
                ", summa=" + summa +
                ", recordUqAlceType=" + recordUqAlceType +
                ", recordUqBCC=" + recordUqBCC +
                ", yearCalc=" + yearCalc +
                '}';
    }
}
