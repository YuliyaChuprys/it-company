package by.chuprys.itcompany.service;

import by.chuprys.itcompany.domain.Educable;

public interface IEducationService {
    /**
     * Rise level of employee to middle.
     *
     * @param educable Employee are able to rise their education level.
     */
    void upLevelToMiddle(Educable educable);

    /**
     * Rise level of employee to senior.
     *
     * @param educable Employee are able to rise their education level.
     */
    void upLevelToSenior(Educable educable);

}
