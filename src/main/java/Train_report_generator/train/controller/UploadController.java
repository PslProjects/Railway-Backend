package Train_report_generator.train.controller;

import Train_report_generator.train.entity.Excel;
import Train_report_generator.train.entity.Input;

import Train_report_generator.train.service.ExcelService;
import Train_report_generator.train.service.InputService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UploadController {
    @Autowired
    private ExcelService excelService;
    @Autowired
    private InputService inputService;

    @PostMapping("/upload")
    public ResponseEntity<HashMap<String, String>> handleFileUpload(
            @RequestParam("journeyDate") String journeyDate,
            @RequestParam("locoNumber") int locoNumber,
            @RequestParam("trainNumber") int trainNumber,
            @RequestParam("trainType") String trainType,
            @RequestParam("lpHeadquarter") String lpHeadquarter,
            @RequestParam("lpName") String lpName,
            @RequestParam("cliname") String cliname,
            @RequestParam("alpHeadquarter") String alpHeadquarter,
            @RequestParam("alpName") String alpName,
            @RequestParam("timeDifference") String timeDifference,
            @RequestParam("spmMaker") String spmMaker,
            @RequestParam("remark") String remark,
            @RequestParam("route") String route,
            @RequestParam("section") String section,
            @RequestParam("file") MultipartFile file) {

        // Process the form data and file here
        Input input = new Input(journeyDate, locoNumber, trainNumber, trainType, section, lpHeadquarter, lpName, cliname, alpHeadquarter, alpName, route,
                timeDifference, spmMaker, remark);

        Input input1 = this.inputService.saveInputData(input);
        if (input1 != null) {
            Excel excel = this.excelService.saveExcelData(file);
        }
        HashMap<String, String> s = new HashMap<String, String>();
        s.put("response", "Data uploaded successfully!");

//        try {
//
//            XSSFWorkbook sheets = new XSSFWorkbook(file.getInputStream());
//
//            XSSFSheet sheet = sheets.getSheetAt(0);
//            int i = 0;
//            if(file.getOriginalFilename() == "TELPRO.xlsx") {
//                 i = 2;
//            }else if(file.getOriginalFilename() == "LAXVEN1"){
//                 i = 6;
//            }else if(file.getOriginalFilename() == "MEDHA"){
//                 i = 13;
//            }
//            for (; i <= sheet.getLastRowNum(); i++) {
//
//                XSSFRow row = sheet.getRow(i);
//                String stringCellValue = row.getCell(0).getStringCellValue();
//                System.out.println(i);
//
//                System.out.println(stringCellValue);
//            if(file.getOriginalFilename() == "TELPRO.xlsx") {
//               if (row == null || row.getCell(0) == null || row.getCell(1) == null || row.getCell(2).getCellType()==CellType.STRING) {
//                    System.out.println("Null data encountered. Stopping processing at row: " + i);
//                    break;
//                 }
//                String stringCellValue1 = row.getCell(1).getStringCellValue();
//                Double stringCellValue2 = row.getCell(2).getNumericCellValue();
//                Double stringCellValue3 = row.getCell(3).getNumericCellValue();
//
//                 System.out.println(stringCellValue1);
//                 System.out.println("distance "+stringCellValue2);
//                 System.out.println("speed "+stringCellValue3);
//            }
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return ResponseEntity.ok(s);
    }

}