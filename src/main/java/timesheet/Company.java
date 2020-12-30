package timesheet;

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
    }

    public Validator getValidator() {
        return validator;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<TimeSheetItem> getTimeSheetItems() {
        return timeSheetItems;
    }

    public List<ReportLine> emptyReportListWithProjects() {
        //TODO
        return null;
    }

    public long sumHours(List<ReportLine> reportLines) {
        //TODO
        return 0;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        //TODO
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String name, int i, Month month) {
        //TODO felec is
        return null;
    }

    public String prepareReport(String name, int i, Month month) {
        //TODO fejlec
        return null;
    }

    public void printToFile(String name, int i, Month month, Path path) {
        //TODO fejlec is
    }

    private void loadEmployees() {
        //TODO
    }

    private void loadProjects() {
        //TODO
    }
}
