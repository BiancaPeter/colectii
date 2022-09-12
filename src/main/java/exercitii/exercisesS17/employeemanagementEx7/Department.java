package exercitii.exercisesS17.employeemanagementEx7;

import java.util.List;

public class Department {
    private String departmentName;
    private String code;
    private List<Employee> employeeList;

    public Department(String departmentName, String code, List<Employee> employeeList) {
        this.departmentName = departmentName;
        this.code = code;
        this.employeeList = employeeList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", code='" + code + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
