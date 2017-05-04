package td.training.linkedinsenior.presentation.presenters;

public interface NewProgrammerView {
    void updateSaveButton(boolean isEnabled);
    void setCaffeine(int caffeine);
    void setEmacs(int emacs);
    void setRealProgrammerRating(int rating);
}
