package timesheet2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private Validator validator;
    private List<Employee> employees;
    private List<Project> projects;
    private List<TimeSheetItem> timeSheetItems;

    public Company(Validator validator) {
        this.validator = validator;
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.timeSheetItems = new ArrayList<>();
        loadEmployees();
        loadProjects();
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public List<ReportLine> emptyReportListWithProjects() {
        //TODO
        return null;
    }

    public long sumHours(List<ReportLine> reportLines) {
        long sum = 0;
        for (ReportLine item : reportLines) {
            sum += item.getTime();
        }
        return sum;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(validator, employee, project, beginDate, endDate));
        //TODO
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String name, int year, Month month) {
        List<ReportLine> reportLines = new ArrayList<>();
        boolean added = false;
        for (TimeSheetItem item : timeSheetItems) {
            if (item.getEmployee().getName().equals(name) && item.getBeginDate().getYear() == year && item.getBeginDate().getMonth() == month) {
                if (reportLines.isEmpty()) {
                    reportLines.add(new ReportLine(item.getProject(), item.countDifferenceBetweenDates().toHours()));
                } else {
                    for (ReportLine re : reportLines) {
                        if (re.getProject().getName().equals(item.getProject().getName())) {
                            re.setTime(item.countDifferenceBetweenDates().toHours());
                            added = true;
                        }
                    }
                    if (!added) {
                        reportLines.add(new ReportLine(item.getProject(), item.countDifferenceBetweenDates().toHours()));

                    }
                    added = false;
                }
            }
        }
        //TODO
        return reportLines;
    }

    public String prepareReport(String name, int year, Month month) {
        if (validator.notInEmployeesList(employees, name)) {
            throw new IllegalArgumentException();
        }
        String monthname;
        if (month.getValue() < 10) {
            monthname = "0" + month.getValue();
        } else {
            monthname = "" + month.getValue();
        }
        StringBuilder sb = new StringBuilder(name + "\t" + year + "-" + monthname + "-" + "01\t");
        long fullHour = 0;

        List<ReportLine> reportLines = calculateProjectByNameYearMonth(name, year, month);
        for (ReportLine item : reportLines) {
            fullHour += item.getTime();
        }
        sb.append(fullHour);
        for (ReportLine item : reportLines) {
            sb.append("\n" + item.getProject().getName() + "\t" + item.getTime());
        }
        //TODO
        return sb.toString();
    }

    public void printToFile(String name, int year, Month month, Path path) {
        //TODO
    }

    private void loadEmployees() {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(Path.of("src", "main", "java", "timesheet", "files", "employees.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                employees.add(new Employee(data[0], data[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO
    }

    private void loadProjects() {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(Path.of("src", "main", "java", "timesheet", "files", "projects.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO
    }
}
