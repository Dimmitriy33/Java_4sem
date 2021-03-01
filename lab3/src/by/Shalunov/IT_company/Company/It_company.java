package by.Shalunov.IT_company.Company;

import by.Shalunov.IT_company.Manager.Manager;
import by.Shalunov.IT_company.Recruitment.RecruitmentPlan;
import by.Shalunov.IT_company.Items.Worker;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class It_company {
    private ArrayList<Worker> workers;
    private RecruitmentPlan recruitmentplan;
    private Manager manager;

    public It_company() {
        workers = new ArrayList<Worker>();
        recruitmentplan = new RecruitmentPlan();
    }

    public It_company(RecruitmentPlan recruitmentplan) {
        this.recruitmentplan = recruitmentplan;
    }

    public It_company(ArrayList<Worker> workers, RecruitmentPlan recruitmentplan) {
        this.workers = workers;
        this.recruitmentplan = recruitmentplan;
    }

    public It_company(RecruitmentPlan recruitmentplan, Manager manager) {
        this.workers = workers;
        this.recruitmentplan = recruitmentplan;
        this.manager = manager;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public RecruitmentPlan getRecruitmentplan() {
        return recruitmentplan;
    }

    public void setRecruitmentplan(RecruitmentPlan recruitmentplan) {
        this.recruitmentplan = recruitmentplan;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Worker> RecruitByDirection(ArrayList<Worker> workers, String direction, int need)
    {
        ArrayList<Worker> newWorkers = new ArrayList<Worker>();
        int take = 0;
        for(int i = workers.size() - 1; i >= 1; i--)
            for(int j = 0; j < i; j++)
                if(workers.get(j).getSkill() < workers.get(j+1).getSkill()) {
                    Worker tempWorker = workers.get(j);
                    workers.set(j, workers.get(j + 1));
                    workers.set(j + 1, tempWorker);
                }
        for(int i = 0; i < workers.size(); i++)
            if(take < need)
                if(workers.get(i).getDirection().toString().equals(direction.toString()))
                {
                    newWorkers.add(workers.get(i));
                    take++;
                }
        return newWorkers;
    }

    public void PrintEmployees()
    {
        for(Worker worker : this.getWorkers())
        {
            System.out.println( "------------------" + System.lineSeparator() +
                    "Name: " + worker.getName() + System.lineSeparator() +
                    "Surname: " + worker.getSurname() + System.lineSeparator() +
                    "Direction: " + worker.getDirection() + System.lineSeparator() +
                    "Skill: " + worker.getSkill() + System.lineSeparator() +
                    "Salary: " + worker.getSalary());
        }
    }
}
