package Train_report_generator.train.service;

import Train_report_generator.train.entity.Excel;
import Train_report_generator.train.repository.ExcelDataRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    private ExcelDataRepository excelDataRepository;

    public Excel saveExcelData(MultipartFile file){
//        return    this.excelRepo.save(excel);
        try {
            System.out.println("file readed -----------------------------");
            XSSFWorkbook sheets = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheetAt = sheets.getSheetAt(0);
            ArrayList<Excel> _list = new ArrayList<>();
            for (int i = 2; i <18014 ; i++) {
                XSSFRow row = sheetAt.getRow(i);
                if ( row.getCell(0) == null || row.getCell(1) == null || row.getCell(2)== null || row.getCell(3) == null ) {
                    System.out.println("Null data encountered. Stopping processing at row: " + i);
                    break;
                }
                else {
                    System.out.println(i);
                    System.out.println(row.getCell(0).getCellType());
                    System.out.println(row.getCell(1).getCellType());
                    System.out.println(row.getCell(2).getCellType());
                    System.out.println(row.getCell(3).getCellType());

                    Excel excel = new Excel(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getNumericCellValue(), row.getCell(3).getNumericCellValue());
//                    Excel save = excelRepo.save(excel);
//                    if(save != null) {
//                        System.out.println("Data saved successfully for row: " + i);
//                    }
                    _list.add(excel);

                }
            }
            List<Excel> excels = this.excelDataRepository.saveAll(_list);
            System.out.println("file readed successfully-----------------------------");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return    new Excel();
    }

}