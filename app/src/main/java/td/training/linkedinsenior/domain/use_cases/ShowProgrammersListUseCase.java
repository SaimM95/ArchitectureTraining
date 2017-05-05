package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.UseCase;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.models.ProgrammerResponse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ShowProgrammersListUseCase implements UseCase {

    @Inject EntityGateway entityGateway;
    private WeakReference<MultipleProgrammerResponseHandler> mHandler;

    public ShowProgrammersListUseCase(EntityGateway entityGateway, MultipleProgrammerResponseHandler handler) {
        this.entityGateway = entityGateway;
        mHandler = new WeakReference<>(handler);
    }

    private List<ProgrammerResponse> processProgrammers(List<Programmer> programmers) {
        ArrayList<ProgrammerResponse> responses = new ArrayList<>();
        for (Programmer programmer : programmers) {
            responses.add(new ProgrammerResponse(programmer));
        }
        return responses;
    }

    @Override
    public void execute() {
        // 1. grab data from persistance
        List<Programmer> programmers = entityGateway.fetchProgrammers();

        // 2. process data
        List<ProgrammerResponse> responses = processProgrammers(programmers);

        // 3. pass it to presenter
        if (mHandler.get() != null) {
            mHandler.get().handleMultipleProgrammerResponses(responses);
        }
    }
}
