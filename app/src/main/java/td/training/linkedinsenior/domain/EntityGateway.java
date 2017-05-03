package td.training.linkedinsenior.domain;

import td.training.linkedinsenior.domain.models.Programmer;

import java.util.List;

public interface EntityGateway {
    List<Programmer> fetchProgrammers();
    void createNewProgrammer(Programmer programmer);
}
