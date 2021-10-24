package com.solvd.itcompany.service;

import com.solvd.itcompany.domain.IDocumentAction;
import com.solvd.itcompany.domain.Project;
import com.solvd.itcompany.domain.ProjectOffer;
import com.solvd.itcompany.domain.Team;

public interface IProjectEstimationService {

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team, float margin);

    ProjectOffer estimateProject(IDocumentAction document, Project project, Team team);

}
