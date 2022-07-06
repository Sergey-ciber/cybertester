package com.cybertester.entity.testCalc;

import com.cybertester.entity.CalcResult;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "test_calc_result")
public class TestCalcResultEntity extends CalcResult {
}
