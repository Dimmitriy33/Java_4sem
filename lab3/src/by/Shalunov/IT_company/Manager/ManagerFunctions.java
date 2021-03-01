package by.Shalunov.IT_company.Manager;
import by.Shalunov.IT_company.Items.Worker;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public interface ManagerFunctions {
    public int NumberOfEmployees(ArrayList<Worker> workers);
    public ArrayList<Worker> SortBySalary(ArrayList<Worker> workers) throws Exception;
    public ArrayList<Worker> FindEmployeesBySkill(ArrayList<Worker> workers, int skillLevel);
    public void validateXMLdocument() throws SAXException, IOException;
}
