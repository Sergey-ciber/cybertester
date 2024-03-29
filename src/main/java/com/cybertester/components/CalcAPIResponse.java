package com.cybertester.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcAPIResponse<T> {

    int docsCount;
    int countError;
    T docList;
    HttpStatus h;
}
