package td.training.linkedinsenior.domain;

import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.models.ProgrammerResponse;

import java.util.List;

/**
 * 20170426. Initial version created by jorge.
 */

public interface UseCase {
    void execute();

    interface SingleProgrammerHandler {
        void handleSingleProgrammer(Programmer programmer);
    }

    interface MultipleProgrammerResponseHandler {
        void handleMultipleProgrammerResponses(List<ProgrammerResponse> programmers);
    }

    interface CompletionHandler {
        void handleCompletion();
    }
}
