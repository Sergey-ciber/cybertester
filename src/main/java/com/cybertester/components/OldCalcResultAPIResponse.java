package com.cybertester.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldCalcResultAPIResponse<T> {

    T oldCalcResultArr;
    HttpStatus h;
}
