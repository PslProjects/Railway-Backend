package Train_report_generator.train.entity;

import jakarta.persistence.*;

@Entity
@Table(name =  "excel_data")
public class Excel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Excel(String date, String time, double distance, double speed) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.speed = speed;
    }

    private String date;

    private String time;

    private double distance;

    private double speed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Excel ()
    {

    }

}