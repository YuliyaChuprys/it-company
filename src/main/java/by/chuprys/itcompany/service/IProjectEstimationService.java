package by.chuprys.itcompany.service;

import by.chuprys.itcompany.domain.IDocumentAction;
import by.chuprys.itcompany.domain.Project;
import by.chuprys.itcompany.domain.ProjectOffer;
import by.chuprys.itcompany.domain.Team;

public interface IProjectEstimationService {

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team, float margin);

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team);

}
