package td.training.linkedinsenior;

import java.util.Date;

public class Programmer {
    private String name;
    private int emacs;

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

    private int caffeine;
    private int realProgrammerRating;
    private Date interviewDate;
    private boolean favorite;
}
