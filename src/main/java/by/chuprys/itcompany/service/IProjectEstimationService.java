package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Document;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.Team;

public interface IProjectEstimationService {

    ProjectOffer estimateProject(Document document, Project project, Team team, float margin);
    ProjectOffer estimateProject(Document document, Project project, Team team);

}
