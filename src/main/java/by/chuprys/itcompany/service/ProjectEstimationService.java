package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Developer;
import main.java.by.chuprys.itcompany.domain.Document;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.QA;
import main.java.by.chuprys.itcompany.domain.Requirement;
import main.java.by.chuprys.itcompany.domain.Team;

import java.math.BigDecimal;

public class ProjectEstimationService implements IProjectEstimationService {

    private static final float MARGIN = 1.5F;

    @Override
    public ProjectOffer estimateProject(Document document, Project project, Team team, float margin) {

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
    public ProjectOffer estimateProject(Document document, Project project, Team team) {

        return estimateProject(document, project, team, MARGIN);

    }

    private BigDecimal calculateTeamSalaryPerMonth(Team team) {
        Developer[] developers = team.getDevelopers();
        QA[] qas = team.getQas();
        BigDecimal teamSalaries = new BigDecimal(0);

        for (int i = 0; i < developers.length; i++) {
            teamSalaries = teamSalaries.add(developers[i].getSalaryPerMonth());
        }

        for (int i = 0; i < qas.length; i++) {
            teamSalaries = teamSalaries.add(qas[i].getSalaryPerMonth());
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
