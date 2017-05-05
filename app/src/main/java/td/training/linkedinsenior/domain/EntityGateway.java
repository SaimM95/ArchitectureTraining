package td.training.linkedinsenior.domain;

import td.training.linkedinsenior.domain.models.Programmer;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Singleton;

@Singleton
public interface EntityGateway {
    List<Programmer> fetchProgrammers();
    Programmer fetchProgrammer(String id);
    void createNewProgrammer(Programmer programmer);
}
