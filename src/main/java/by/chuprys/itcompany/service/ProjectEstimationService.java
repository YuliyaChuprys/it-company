package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Developer;
import main.java.by.chuprys.itcompany.domain.IDocumentAction;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.QA;
import main.java.by.chuprys.itcompany.domain.Requirement;
import main.java.by.chuprys.itcompany.domain.Team;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProjectEstimationService implements IProjectEstimationService {

    private static final float MARGIN = 1.5F;

    @Override
    public ProjectOffer estimateProject(IDocumentAction document, Project project, Team team, float margin) {
        int storyPoints = calculateProjectStoryPoints(project.getRequirement());
        int teamCapacity = team.getCapacityPerMonth();
        float numberOfMonth = storyPoints / teamCapacity;
        BigDecimal teamSalaryPerMonth = calculateTeamSalaryPerMonth(team);
        BigDecimal price = teamSalaryPerMonth.multiply(BigDecimal.valueOf(numberOfMonth))
                .multiply(BigDecimal.valueOf(margin));
        int documentId = document.getDocumentId();
        String documentTitle = document.getDocumentTitle();
        return new ProjectOffer(documentId, documentTitle, price, numberOfMonth, project, team);
    }

    @Override
    public ProjectOffer estimateProject(IDocumentAction document, Project project, Team team) {

        return estimateProject(document, project, team, MARGIN);

    }

    private BigDecimal calculateTeamSalaryPerMonth(Team team) {
        Set<Developer> developers = team.getDevelopers();
        Set<QA> qas = team.getQas();
        BigDecimal teamSalaries = new BigDecimal(0);

        for (Developer developer:developers) {
            teamSalaries = teamSalaries.add(developer.getSalaryPerMonth());
        }

        for (QA qa:qas) {
            teamSalaries = teamSalaries.add(qa.getSalaryPerMonth());
        }

        teamSalaries = teamSalaries.add(team.getProjectManager().getSalaryPerMonth());
        return teamSalaries;

    }

    private int calculateProjectStoryPoints(Requirement requirement) {
        int features = requirement.getFeatures();
        if (features < 5) {
            return 720;
        } else if (features < 10) {
            return 1000;
        } else {
            return 1500;
        }
    }


}
