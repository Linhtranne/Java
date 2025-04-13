package businness.dao.statistiFcunction;

import java.util.List;
import java.util.Map;

public interface StatistiFcunctionDao {
    List<Map<String, Object>> countEmployeesByDepartment();
    int countTotalEmployees();
    Map<String, Object> departmentWithMostEmployees();
    Map<String, Object> departmentWithHighestSalary();
}
