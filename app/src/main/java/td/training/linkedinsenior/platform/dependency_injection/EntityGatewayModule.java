package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.models.Programmer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

@Module
public class EntityGatewayModule {

    private final long ONE_DAY = 24 * 60 * 60 * 1000;

    @Singleton
    @Provides
    EntityGateway providesEntityGateway() {
        List<Programmer> programmers = new ArrayList<>();
        programmers.add(createProgrammer("prog1", "Bob", 2, 3, 8, Calendar.getInstance().getTime(), false));
        Date yesterday = new Date(Calendar.getInstance().getTime().getTime() - ONE_DAY);
        programmers.add(createProgrammer("prog2", "Alice", 6, 6, 8, yesterday, true));

        return new InMemoryRepo(programmers);
    }

    private Programmer createProgrammer(String id, String name, int emacs, int caffeine, int realProgrammerRating, Date interviewDate, boolean favorite) {
        Programmer programmer = new Programmer();
        programmer.setId(id);
        programmer.setName(name);
        programmer.setEmacs(emacs);
        programmer.setCaffeine(caffeine);
        programmer.setRealProgrammerRating(realProgrammerRating);
        programmer.setInterviewDate(interviewDate);
        programmer.setFavorite(favorite);
        return programmer;
    }
}
