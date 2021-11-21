package com.study.cvstodb;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileDto {

    @CsvBindByName(column = "도서관 일련번호")
    private String no;

    @CsvBindByName(column = "도서관명")
    private String name;

    @CsvBindByName(column = "구 코드")
    private String guCode;

    @CsvBindByName(column = "주소")
    private String address;

    @CsvBindByName(column = "전화번호")
    private String tel;

    @CsvBindByName(column = "도서관 구분명")
    private String type;

    public FileDto() {
    }
}
