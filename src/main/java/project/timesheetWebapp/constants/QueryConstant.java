package project.timesheetWebapp.constants;

public class QueryConstant {
public static StringBuilder GET_TIMESHEET = new StringBuilder("SELECT id,Date,hours,task as name,employee_id FROM TIMESHEET WHERE EMPLOYEE_ID = ? AND DATE = ?") ;

}
