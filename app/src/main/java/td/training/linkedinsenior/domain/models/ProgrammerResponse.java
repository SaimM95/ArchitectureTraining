package td.training.linkedinsenior.domain.models;

import java.util.Date;

public class ProgrammerResponse {
    private final String name;
    private final boolean favorite;
    private final Date interviewDate;

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public ProgrammerResponse(Programmer programmer) {
        name = programmer.getName();
        favorite = programmer.isFavorite();
        interviewDate = programmer.getInterviewDate();
    }
}
