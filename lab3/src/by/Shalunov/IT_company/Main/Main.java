package by.Shalunov.IT_company.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import by.Shalunov.IT_company.Company.It_company;
import by.Shalunov.IT_company.Items.Worker;
import by.Shalunov.IT_company.Manager.Manager;
import by.Shalunov.IT_company.Recruitment.DirectionPlan;
import by.Shalunov.IT_company.Recruitment.RecruitmentPlan;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.stream.*;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    private static ArrayList<Worker> sortWorkers;

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {


        LOG.info("Starting program_____________________________" + System.lineSeparator());
        LOG.info("Creating and initializing my IT-company_____________________________" + System.lineSeparator());
        It_company it_company = new It_company(new RecruitmentPlan(
                new DirectionPlan("engineers", 2),
                new DirectionPlan("securitySpecialists", 1),
                new DirectionPlan("analyst", 1),
                new DirectionPlan("juniorProgrammer", 3),
                new DirectionPlan("middleProgrammer", 1),
                new DirectionPlan("seniorProgrammer", 2)
                ), new Manager("Walt", "Disney"));
        LOG.info("Creating temp files_____________________________" + System.lineSeparator());
        ArrayList<Worker> potentialWorkers = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        LOG.info("Creating and initializing my manager_____________________________" + System.lineSeparator());


        LOG.info("Adding elements to potrntial employees array_____________________________" + System.lineSeparator());
        potentialWorkers.add(0 ,new Worker("Shalunov", "Dmitriy", "juniorProgrammer",4, 400));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Newton", "Isaak", "engineer",9, 1800));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Lun", "Tsai", "analyst",6, 800));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Gutenberg", "Johann", "middleProgrammer",5, 800));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Columb", "Christopher", "securitySpecialists",4, 400));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Darwin", "Charles", "seniorProgrammer",8, 1500));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Copernic", "Nicolay", "juniorProgrammer",3, 300));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Polo", "Marco", "juniorProgrammer",2, 200));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Faradey", "Miсhael", "securitySpecialists",7, 1100));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Washington", "George", "middleProgrammer",6, 1000));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Lincoln", "Abraham", "seniorProgrammer",8, 1700));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Luther", "Martin", "securitySpecialists",3, 600));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Churchill", "Winston", "middleProgrammer",2, 400));
        potentialWorkers.add(potentialWorkers.size() ,new Worker("Kennedy", "John", "juniorProgrammer",10, 2400));

        try {
            LOG.info("Adding employees to temp array_____________________________" + System.lineSeparator());
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "engineer",
                    it_company.getRecruitmentplan().getEngineers().getCount()));
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "securitySpecialists",
                    it_company.getRecruitmentplan().getSecuritySpecialists().getCount()));
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "analyst",
                    it_company.getRecruitmentplan().getAnalysts().getCount()));
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "juniorProgrammer",
                    it_company.getRecruitmentplan().getJuniorProgrammer().getCount()));
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "middleProgrammer",
                    it_company.getRecruitmentplan().getMiddleProgrammer().getCount()));
            workers.addAll(it_company.RecruitByDirection(potentialWorkers, "seniorProgrammer",
                    it_company.getRecruitmentplan().getSeniorProgrammer().getCount()));
        } catch (Exception e) {
            LOG.error("Error during adding employees to tmp array _____________________________" + System.lineSeparator());
            throw new Exception("error during the recruitment");
        }
        LOG.info("Adding employees to my IT-company_____________________________" + System.lineSeparator());
        it_company.setWorkers(workers);

        LOG.info("Printing employees of my IT-company_____________________________" + System.lineSeparator());
        System.out.println("Employees");
        it_company.PrintEmployees();

        LOG.info("Testing manager functions_____________________________" + System.lineSeparator());
        System.out.println(System.lineSeparator() + "Manager functions");
        try {
            LOG.info("Calculating and printing number of employees of  my IT-company_____________________________" + System.lineSeparator());
            System.out.println("Number of employees: " + it_company.getManager().NumberOfEmployees(workers));
        } catch (Exception e) {
            LOG.error("Error during calculating and printing number of employees of  my IT-company" + System.lineSeparator());
            throw new Exception(e.getMessage());
        }

        try{
            LOG.info("Sorting employees of  my IT-company by salary_____________________________" + System.lineSeparator());
            System.out.println("Sort by salary: ");
            workers = it_company.getManager().SortBySalary(workers);
            it_company.PrintEmployees();
        } catch (Exception e) {
            LOG.error("Error during sorting employees by salary" + System.lineSeparator());
            throw new Exception(e.getMessage());
        }

        try {
            LOG.info("Finding employees with certain level of skill_____________________________" + System.lineSeparator());
            ArrayList<Worker> EmployeesWithCertainLevel = it_company.getManager().FindEmployeesBySkill(workers,6);
            System.out.println("EmployeesWithCertainLevel: ");
            for(Worker worker : EmployeesWithCertainLevel)
            {
                System.out.println( "------------------" + System.lineSeparator() +
                        "Name: " + worker.getName() + System.lineSeparator() +
                        "Surname: " + worker.getSurname() + System.lineSeparator() +
                        "Direction: " + worker.getDirection() + System.lineSeparator() +
                        "Skill: " + worker.getSkill() + System.lineSeparator() +
                        "Salary: " + worker.getSalary());
            }
        } catch (Exception e) {
            LOG.error("Error during finding employees with certain level of skill_____________________________" + System.lineSeparator());
            throw new Exception(e.getMessage());
        }

        //lab 4

        It_company It_from_XML = new It_company();
        try {
            it_company.getManager().validateXMLdocument();
            System.out.println("Validation success");
        } catch(Exception e) {
            LOG.error(e.getMessage());
        }

        Worker worker = null;
        RecruitmentPlan recruitmentPlan = null;
        DirectionPlan directionPlan = null; 
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try
        {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader
                    (new FileInputStream("files/It_company_XML.xml"));
            while(reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String curElement = startElement.getName().getLocalPart();

                    switch (curElement) {
                        case "worker" -> worker = new Worker();
                        case "name" -> {
                            event = reader.nextEvent();
                            worker.setName(event.asCharacters().getData());
                        }
                        case "surname" -> {
                            event = reader.nextEvent();
                            worker.setSurname(event.asCharacters().getData());
                        }
                        case "direction" -> {
                            event = reader.nextEvent();
                            worker.setDirection(event.asCharacters().getData());
                        }
                        case "skill" -> {
                            event = reader.nextEvent();
                            worker.setSkill(Integer.parseInt(event.asCharacters().getData()));
                        }
                        case "salary" -> {
                            event = reader.nextEvent();
                            worker.setSalary(Double.parseDouble(event.asCharacters().getData()));
                        }
                    }

                    switch (curElement) {
                        case "RecruitmentPlan" -> recruitmentPlan = new RecruitmentPlan();
                        case "DirectionPlan" -> directionPlan = new DirectionPlan();
                        case "plandirection" -> {
                            event = reader.nextEvent();
                            directionPlan.setDirection(event.asCharacters().getData());
                        }
                        case "count" -> {
                            event = reader.nextEvent();
                            directionPlan.setCount(Integer.parseInt(event.asCharacters().getData()));
                        }
                    }
                }
                if(event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    String curElement = event.asEndElement().getName().getLocalPart();
                    if(curElement.equals("worker")) {
                        It_from_XML.getWorkers().add(worker);
                    }

                    if(curElement.equals("RecruitmentPlan"))
                        It_from_XML.setRecruitmentplan(recruitmentPlan);
                    else if (curElement.equals("DirectionPlan")) {
                        switch (directionPlan.getDirection()) {
                            case "engineers" -> recruitmentPlan.setEngineers(directionPlan);
                            case "analysts" -> recruitmentPlan.setAnalysts(directionPlan);
                            case "securitySpecialists" -> recruitmentPlan.setSecuritySpecialists(directionPlan);
                            case "juniorProgrammer" -> recruitmentPlan.setJuniorProgrammer(directionPlan);
                            case "middleProgrammer" -> recruitmentPlan.setMiddleProgrammer(directionPlan);
                            case "seniorProgrammer" -> recruitmentPlan.setSeniorProgrammer(directionPlan);
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        //сериализация и десериализация
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("files/it_company.json");
        gson.toJson(it_company, file);
        file.flush();
        FileReader fileR = new FileReader("files/it_company.json");
        It_company deserialize_it_company = gson.fromJson(fileR, It_company.class);
        deserialize_it_company.PrintEmployees();

        // работа со stream api
        ArrayList<Worker> sortWorkers = (ArrayList<Worker>) it_company.getWorkers().stream()
                .sorted(Comparator.comparing(Worker::getSkill))
                .distinct()
                .collect(Collectors.toList());

    }
}
