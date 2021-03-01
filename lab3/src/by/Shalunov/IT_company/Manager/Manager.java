

package by.Shalunov.IT_company.Manager;

import by.Shalunov.IT_company.Items.Person;
import by.Shalunov.IT_company.Items.Worker;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends Person implements ManagerFunctions {
    public Manager() {
    }

    public Manager(String name, String surname) {
        super(name, surname);
    }

    @Override
    public int NumberOfEmployees(ArrayList<Worker> workers) {
        return workers.size();
    }

    @Override
    public ArrayList<Worker> SortBySalary(ArrayList<Worker> workers) throws Exception {
        if(workers.size() < 1)
            throw new Exception("array is empty");
        for(int i = workers.size() - 1; i >= 1; i--)
            for(int j = 0; j < i; j++)
                if(workers.get(j).getSalary() < workers.get(j+1).getSalary()) {
                    Worker tempWorker = workers.get(j);
                    workers.set(j, workers.get(j + 1));
                    workers.set(j + 1, tempWorker);
                }
        return workers;
    }

    @Override
    public ArrayList<Worker> FindEmployeesBySkill(ArrayList<Worker> workers, int skillLevel) {
        ArrayList<Worker> newWorkers = new ArrayList<Worker>();
        for(Worker worker : workers)
            if(worker.getSkill() == skillLevel)
                newWorkers.add(worker);
            return  newWorkers;
    }

    @Override
    public void validateXMLdocument() throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new StreamSource("files/It_company_XSD.xsd"));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource("files/It_company_XML.xml"));
    }
}
