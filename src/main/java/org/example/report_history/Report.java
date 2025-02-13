package org.example.report_history;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private Long id;

    private String studentUserName;

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    private Integer hours;

    public Long getId() {
        return id;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return
                id + "\n" +
                        studentUserName + "\n" +
                        hours + "\n" +
                        date + "\n" +
                        title + "\n"

                ;
    }

    public String getTitle() {
        return title;
    }

    private LocalDate date;

    private String title;

    public static String reportHistory(List<Report> reports, String studentUserName, int count) {
        return reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .sorted(Comparator.comparing(Report::getDate))
                .limit(count)
                .map(report -> report.toString() + "\n---------------\n")
                .collect(Collectors.joining("\n"));
    }
}