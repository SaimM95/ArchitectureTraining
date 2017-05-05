package td.training.linkedinsenior.presentation.presenters;

/**
 * 20170423. Initial version created by jorge.
 */

public interface ProgrammerDetailView {
    void displayName(String name);
    void setUpFavorite(Boolean favorite);
    void displayEmacs(String emacsLabel);
    void displayCaffeine(String caffeineLabel);
    void displayRealProgrammerRating(Integer value);
}
