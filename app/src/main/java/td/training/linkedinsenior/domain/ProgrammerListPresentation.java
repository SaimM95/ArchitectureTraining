package td.training.linkedinsenior.domain;

import td.training.linkedinsenior.domain.models.ProgrammerResponse;

import java.util.List;

public interface ProgrammerListPresentation {
    void present(List<ProgrammerResponse> programmerResponses);
}
