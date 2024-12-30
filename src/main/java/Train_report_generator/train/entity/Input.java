package Train_report_generator.train.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="form_data")
public class Input {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String journeyDate;
 private Integer locoNumber;
 private Integer trainNumber;
 private String trainType;

 public Input(String journeyDate, Integer locoNumber, Integer trainNumber, String trainType, String section, String lpHeadquarter, String lpName, String cliName, String alpHeadquarter, String alpName, String timeDifference, String route, String spmMaker, String remark) {
  this.journeyDate = journeyDate;
  this.locoNumber = locoNumber;
  this.trainNumber = trainNumber;
  this.trainType = trainType;
  this.section = section;
  this.lpHeadquarter = lpHeadquarter;
  this.lpName = lpName;
  this.cliName = cliName;
  this.alpHeadquarter = alpHeadquarter;
  this.alpName = alpName;
  this.timeDifference = timeDifference;
  this.route = route;
  this.spmMaker = spmMaker;
  this.remark = remark;
 }

 private String section;
 private String lpHeadquarter;
 private String lpName;
 private String cliName;
 private String alpHeadquarter;
 private String alpName;
 private String route;
 private String timeDifference;
 private String spmMaker;
 private String remark;

   public Input (){
   }


}