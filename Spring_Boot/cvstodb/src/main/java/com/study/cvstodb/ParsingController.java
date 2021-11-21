package com.study.cvstodb;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
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

    public ParsingController(ParsingRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) throws IOException {

        //받아온 CSV 파일 읽음
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // CSV을 Bean으로 만들어줌
            CsvToBean<FileDto> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(FileDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // CSV Bean을 list에 for문을 통해 담아줌
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
