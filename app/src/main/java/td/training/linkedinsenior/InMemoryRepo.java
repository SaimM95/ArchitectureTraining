package td.training.linkedinsenior;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InMemoryRepo implements EntityGateway {

    private List<Programmer> programmers;

    public InMemoryRepo() {
        programmers = new ArrayList<>();
        programmers.add(createProgrammer("Bob", 2, 3, 8, Calendar.getInstance().getTime(), false));
        programmers.add(createProgrammer("Alice", 6, 6, 8, Calendar.getInstance().getTime(), true));
    }

    @Override
    public List<Programmer> fetchProgrammers() {
        return programmers;
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
