package td.training.linkedinsenior.data;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.models.Programmer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InMemoryRepo implements EntityGateway {

    private List<Programmer> programmers;
    private final long ONE_DAY = 24 * 60 * 60 * 1000;

    public InMemoryRepo() {
        programmers = new ArrayList<>();
        programmers.add(createProgrammer("Bob", 2, 3, 8, Calendar.getInstance().getTime(), false));
        Date yesterday = new Date(Calendar.getInstance().getTime().getTime() - ONE_DAY);
        programmers.add(createProgrammer("Alice", 6, 6, 8, yesterday, true));
    }

    @Override
    public List<Programmer> fetchProgrammers() {
        return programmers;
    }

    @Override
    public void createNewProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    private Programmer createProgrammer(String name, int emacs, int caffeine, int realProgrammerRating, Date interviewDate, boolean favorite) {
        Programmer programmer = new Programmer();
        programmer.setName(name);
        programmer.setEmacs(emacs);
        programmer.setCaffeine(caffeine);
        programmer.setRealProgrammerRating(realProgrammerRating);
        programmer.setInterviewDate(interviewDate);
        programmer.setFavorite(favorite);
        return programmer;
    }
}
