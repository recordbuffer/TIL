package com.study.cvstodb;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class ParsingController {

    private ParsingRepository repo;

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        // parse CSV file to create a list of `User` objects
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<FileDto> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(FileDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of dataList
            List<FileDto> dataList = csvToBean.parse();

            for (int i = 0; i < dataList.size(); i++) {
                FileDto dto = dataList.get(i);

                Library l = new Library();

                //no
                l.setNo(Long.parseLong(dto.getNo()));
                //name
                l.setName(dto.getName());
                //guCode
                l.setGuCode(Integer.parseInt(dto.getGuCode()));
                //address
                l.setAddress(dto.getAddress());
                //tel
                l.setTel(dto.getTel());
                //type
                l.setType(dto.getType());

                repo.save(l);
            }

        }

        return "result";
    }
}
