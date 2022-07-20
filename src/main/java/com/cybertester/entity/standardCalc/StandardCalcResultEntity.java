package com.cybertester.entity.standardCalc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "DX_RESULT", schema = "FSBS")
public class StandardCalcResultEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECORD_UQ")
    private long recordUq;

    @Column(name = "PERIOD_BEG_DAY")
    private String periodBegDay;

    @Column(name = "PERIOD_END_DAY")
    private String periodEndDay;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "RECORD_UQ_REGISTR")
    private long recordUqRegistr;

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
        return "\nРасчет из БД ПВСО:" +
                "\n record_uq = " + recordUq +
                "\n Начало периода = '" + periodBegDay + '\'' +
                "\n Конец периода = '" + periodEndDay + '\'' +
                "\n Сумма дня = " + price +
                "\n recordUqRegister = " + recordUqRegistr +
                "\n Процент= " + periodPercent +
                "\n Сумма дня с учетом процентов = " + pricesPercent +
                "\n Количество дней = " + countDays +
                "\n Сумма = " + summa +
                "\n Тип пособия = " + recordUqAlceType +
                "\n КБК = " + recordUqBCC +
                "\n Год учета = " + yearCalc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordUq, periodBegDay, periodEndDay, price, periodPercent, pricesPercent,
                countDays, summa, recordUqAlceType, recordUqBCC, yearCalc);
    }
}
