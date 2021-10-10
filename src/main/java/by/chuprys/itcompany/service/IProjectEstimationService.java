package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.IDocumentAction;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.Team;

public interface IProjectEstimationService {

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team, float margin);

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team);

}
