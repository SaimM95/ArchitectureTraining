package td.training.linkedinsenior.domain.models;

import java.util.Date;

public class ProgrammerResponse {
    private String id;
    private String name;
    private boolean favorite;
    private Date interviewDate;

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public String getId() {
        return id;
    }

    public ProgrammerResponse(Programmer programmer) {
        id = programmer.getId();
        name = programmer.getName();
        favorite = programmer.isFavorite();
        interviewDate = programmer.getInterviewDate();
    }
}
