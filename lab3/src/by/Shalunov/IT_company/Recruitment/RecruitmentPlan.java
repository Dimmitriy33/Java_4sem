package by.Shalunov.IT_company.Recruitment;

public class RecruitmentPlan
{
    private DirectionPlan engineers;
    private DirectionPlan analysts;
    private DirectionPlan securitySpecialists;
    private DirectionPlan juniorProgrammer;
    private DirectionPlan middleProgrammer;
    private DirectionPlan seniorProgrammer;

    public RecruitmentPlan() {
    }

    public RecruitmentPlan(DirectionPlan engineers,
                           DirectionPlan analysts,
                           DirectionPlan securitySpecialists,
                           DirectionPlan juniorProgrammer,
                           DirectionPlan middleProgrammer,
                           DirectionPlan seniorProgrammer) {
        this.engineers = engineers;
        this.analysts = analysts;
        this.securitySpecialists = securitySpecialists;
        this.juniorProgrammer = juniorProgrammer;
        this.middleProgrammer = middleProgrammer;
        this.seniorProgrammer = seniorProgrammer;
    }

    public DirectionPlan getEngineers() {
        return engineers;
    }

    public void setEngineers(DirectionPlan engineers) {
        this.engineers = engineers;
    }

    public DirectionPlan getAnalysts() {
        return analysts;
    }

    public void setAnalysts(DirectionPlan analysts) {
        this.analysts = analysts;
    }

    public DirectionPlan getSecuritySpecialists() {
        return securitySpecialists;
    }

    public void setSecuritySpecialists(DirectionPlan securitySpecialists) {
        this.securitySpecialists = securitySpecialists;
    }

    public DirectionPlan getJuniorProgrammer() {
        return juniorProgrammer;
    }

    public void setJuniorProgrammer(DirectionPlan juniorProgrammer) {
        this.juniorProgrammer = juniorProgrammer;
    }

    public DirectionPlan getMiddleProgrammer() {
        return middleProgrammer;
    }

    public void setMiddleProgrammer(DirectionPlan middleProgrammer) {
        this.middleProgrammer = middleProgrammer;
    }

    public DirectionPlan getSeniorProgrammer() {
        return seniorProgrammer;
    }

    public void setSeniorProgrammer(DirectionPlan seniorProgrammer) {
        this.seniorProgrammer = seniorProgrammer;
    }
}
