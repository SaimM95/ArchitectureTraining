package td.training.linkedinsenior.domain.models;

import java.util.Date;

public class Programmer {
    public void setName(String name) {
        this.name = name;
    }

    public void setEmacs(int emacs) {
        this.emacs = emacs;
    }

    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
    }

    public void setRealProgrammerRating(int realProgrammerRating) {
        this.realProgrammerRating = realProgrammerRating;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getId() {
        return id;
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private int emacs;
    private int caffeine;
    private int realProgrammerRating;
    private Date interviewDate;
    private boolean favorite;

    public String getName() {
        return name;
    }

    public int getEmacs() {
        return emacs;
    }

    public int getCaffeine() {
        return caffeine;
    }

    public int getRealProgrammerRating() {
        return realProgrammerRating;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public boolean isFavorite() {
        return favorite;
    }

}
