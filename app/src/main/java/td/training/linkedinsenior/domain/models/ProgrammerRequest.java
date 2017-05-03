package td.training.linkedinsenior.domain.models;

import java.util.Date;
import java.util.Observable;

public class ProgrammerRequest extends Observable {

    private String name;
    private int emacs;
    private int caffeine;
    private int realProgrammerRating;
    private Date interviewDate;
    private boolean favorite;

    public ProgrammerRequest() {
        this("", 2, 2, 2, null, false);
    }

    public ProgrammerRequest(String name, Integer emacs, Integer caffeine, Integer realProgrammerRating, Date interviewDate, Boolean favorite) {
        this.name = name;
        this.emacs = emacs;
        this.caffeine = caffeine;
        this.realProgrammerRating = realProgrammerRating;
        this.interviewDate = interviewDate;
        this.favorite = favorite;
    }

    public ProgrammerRequest(Programmer programmer) {
        name = programmer.getName();
        emacs = programmer.getEmacs();
        caffeine = programmer.getCaffeine();
        realProgrammerRating = programmer.getRealProgrammerRating();
        interviewDate = programmer.getInterviewDate();
        favorite = programmer.isFavorite();
    }

    public void setName(String name) {
        this.name = name;
        mNotifyObservers();
    }

    public void setEmacs(int emacs) {
        this.emacs = emacs;
        setRealProgrammerRating();
        mNotifyObservers();

    }

    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
        setRealProgrammerRating();
        mNotifyObservers();
    }

    private void setRealProgrammerRating() {
        this.realProgrammerRating = (emacs + caffeine) / 2;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
        mNotifyObservers();
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
        mNotifyObservers();
    }

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

    private void mNotifyObservers() {
        setChanged();
        notifyObservers();
    }
}
