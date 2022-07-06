package com.cybertester.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@MappedSuperclass
public class CalcResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECORD_UQ")
    private int id;

    @Column(name = "PERIOD_BEG_DAY")
    private String periodBegDay;

    @Column(name = "PERIOD_END_DAY")
    private String periodEndDay;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "RECORD_UQ_REGISTR")
    private int recordUQRegister;

    @Column(name = "PERIOD_PERCENT")
    private int periodPercent;

    @Column(name = "PRICES_PERCENT")
    private double pricesPercent;

    @Column(name = "COUNT_DAYS")
    private double countDays;

    @Column(name = "SUMMA")
    private double summa;

    @Column(name = "RECORD_UQ_ALCE_TYPE")
    private int recordUqAlceType;

    @Column(name = "RECORD_UQ_BCC")
    private int recordUqBCC;

    @Column(name = "YEAR_CALC")
    private int yearCalc;

    @Override
    public String toString() {
        return "CalcResult{" +
                "id=" + id +
                ", periodBegDay='" + periodBegDay + '\'' +
                ", periodEndDay='" + periodEndDay + '\'' +
                ", price=" + price +
                ", periodPercent=" + periodPercent +
                ", pricesPercent=" + pricesPercent +
                ", countDays=" + countDays +
                ", summa=" + summa +
                ", recordUqAlceType=" + recordUqAlceType +
                ", recordUqBCC=" + recordUqBCC +
                ", yearCalc=" + yearCalc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcResult that = (CalcResult) o;
        return  Double.compare(that.price, price) == 0 &&
                periodPercent == that.periodPercent &&
                Double.compare(that.pricesPercent, pricesPercent) == 0 &&
                Double.compare(that.countDays, countDays) == 0 &&
                Double.compare(that.summa, summa) == 0 &&
                recordUqAlceType == that.recordUqAlceType &&
                recordUqBCC == that.recordUqBCC &&
                yearCalc == that.yearCalc &&
                Objects.equals(periodBegDay, that.periodBegDay) &&
                Objects.equals(periodEndDay, that.periodEndDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, periodBegDay, periodEndDay, price, periodPercent, pricesPercent, countDays, summa, recordUqAlceType, recordUqBCC, yearCalc);
    }
}