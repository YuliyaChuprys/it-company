package com.solvd.itcompany.service;

import com.solvd.itcompany.domain.Developer;
import com.solvd.itcompany.domain.IDocumentAction;
import com.solvd.itcompany.domain.Project;
import com.solvd.itcompany.domain.ProjectOffer;
import com.solvd.itcompany.domain.QA;
import com.solvd.itcompany.domain.Requirement;
import com.solvd.itcompany.domain.Team;

import java.math.BigDecimal;
import java.util.List;

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
        List<Developer> developers = team.getDevelopers();
        List<QA> qas = team.getQas();
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
