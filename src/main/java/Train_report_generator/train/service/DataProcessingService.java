//package Train_report_generator.train.service;
//
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.time.LocalTime;
//import java.util.List;
//
//@Service
//public class DataProcessingService {
//
//    private List<String> dateList;
//    private List<String> timeList;
//    private List<Double> speedList;
//    private List<Double> distanceList;
//
//    // Method to process and store data from the controller
//    public void processData(List<String> dateList, List<String> timeList, List<Double> distanceList, List<Double> speedList) {
//        this.dateList = dateList;
//        this.timeList = timeList;
//        this.distanceList = distanceList;
//        this.speedList = speedList;
//
//        if (timeList != null && !timeList.isEmpty()) {
//            String start = timeList.get(0);
//            String end = timeList.get(timeList.size() - 1);
//
//            // Example: Calculate average speed
//            calculateJourneyTime(start, end);
//
//
//            System.out.println(start);
//            System.out.println(end);
//        } else {
//            System.out.println("Time list is empty or null. Cannot calculate journey time.");
//        }
//    }
//
//    // Getter methods to access the data
//    public List<String> getDateList() {
//        return dateList;
//    }
//
//    public List<String> getTimeList() {
//        return timeList;
//    }
//
//    public List<Double> getSpeedList() {
//        return speedList;
//    }
//
//    public List<Double> getDistanceList() {
//        return distanceList;
//    }
//
//    // Example: Calculate journey time
//    public void calculateJourneyTime(String start, String end) {
//        try {
//            // Parse the strings into LocalTime objects
//            LocalTime startTime = LocalTime.parse(start);
//            LocalTime endTime = LocalTime.parse(end);
//
//            // Calculate the duration between the two times
//            Duration duration = Duration.between(startTime, endTime);
//            // Handle case where endTime is on the next day
//            if (duration.isNegative()) {
//                duration = duration.plusHours(24);
//            }
//
//            // Get the difference in hours and minutes
//            long hours = duration.toHours();
//            long minutes = duration.toMinutes() % 60;
//
//            System.out.println("Journey Time: " + hours + " hours and " + minutes + " minutes");
//        } catch (Exception e) {
//            System.out.println("Error parsing time: " + e.getMessage());
//        }
//    }
//
//    // Additional operations can be added here, such as calculating total distance, time intervals, etc.
//}
