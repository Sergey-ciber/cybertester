package com.cybertester.entity.standardCalc;

import com.cybertester.entity.CalcResult;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DX_RESULT", schema = "FSBS")
public class StandardCalcResultEntity extends CalcResult {
}
