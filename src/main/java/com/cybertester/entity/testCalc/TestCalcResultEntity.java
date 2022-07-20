package com.cybertester.entity.testCalc;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "test_calc_result", schema = "public")
public class TestCalcResultEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "record_uq")
    private long recordUq;

    @Column(name = "period_beg_day")
    private String periodBegDay;

    @Column(name = "period_end_day")
    private String periodEndDay;

    @Column(name = "price")
    private double price;

    @Column(name = "record_uq_registr", nullable=true)
    private long recordUqRegistr;

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
        return "\nРасчет из тестовой БД" +
                "\n ИД =" + id +
                "\n record_uq=" + recordUq +
                "\n Начало периода ='" + periodBegDay + '\'' +
                "\n Конец периода ='" + periodEndDay + '\'' +
                "\n Сумма дня =" + price +
                "\n recordUQRegister=" + recordUqRegistr +
                "\n Процент=" + periodPercent +
                "\n Сумма дня с учетом процентов=" + pricesPercent +
                "\n Количество дней=" + countDays +
                "\n Сумма=" + summa +
                "\n Тип пособия =" + recordUqAlceType +
                "\n КБК =" + recordUqBCC +
                "\n Год учета =" + yearCalc;
    }
}
