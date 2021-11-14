package com.study.cvstodb;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileDto {

    @CsvBindByPosition(position = 0)
    private String no;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String guCode;

    @CsvBindByPosition(position = 4)
    private String address;

    @CsvBindByPosition(position = 5)
    private String tel;

    @CsvBindByPosition(position = 9)
    private String type;

    public FileDto() {
    }
}
