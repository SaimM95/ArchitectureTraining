package td.training.linkedinsenior;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ShowProgrammersListUseCase {

    private EntityGateway entityGateway;
    private WeakReference<ProgrammerListPresentation> presenter;

    @Inject
    public ShowProgrammersListUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void showProgrammers() {
        // 1. grab data from persistance
        List<Programmer> programmers = entityGateway.fetchProgrammers();

        // 2. process data
        List<ProgrammerResponse> responses = processProgrammers(programmers);

        // 3. pass it to presenter
        if (presenter.get() != null) {
            presenter.get().present(responses);
        }
    }

    public void setPresenter(ProgrammerListPresentation presenter) {
        this.presenter = new WeakReference<>(presenter);
    }

    private List<ProgrammerResponse> processProgrammers(List<Programmer> programmers) {
        ArrayList<ProgrammerResponse> responses = new ArrayList<>();
        for (Programmer programmer : programmers) {
            responses.add(new ProgrammerResponse(programmer));
        }
        return responses;
    }
}
