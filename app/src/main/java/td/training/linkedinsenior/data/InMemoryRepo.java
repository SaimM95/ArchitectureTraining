package td.training.linkedinsenior.data;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.models.Programmer;

import java.util.List;
import java.util.Observable;

public class InMemoryRepo extends Observable implements EntityGateway {

    private List<Programmer> programmers;

    public InMemoryRepo(List<Programmer> programmers) {
        this.programmers = programmers;
    }

    @Override
    public List<Programmer> fetchProgrammers() {
        return programmers;
    }

    @Override
    public void createNewProgrammer(Programmer programmer) {
        programmers.add(programmer);
        setChanged();
        notifyObservers();
    }

}
