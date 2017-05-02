package td.training.linkedinsenior;

import java.util.ArrayList;
import java.util.List;

public class ShowProgrammersListUseCase {

    private EntityGateway entityGateway;
    private ProgrammerListPresentation presenter;

    public ShowProgrammersListUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void showProgrammers() {
        // 1. grab data from persistance
        List<Programmer> programmers = entityGateway.fetchProgrammers();

        // 2. process data
        List<ProgrammerResponse> responses = processProgrammers(programmers);

        // 3. pass it to presenter
        presenter.present(responses);
    }

    public void setPresenter(ProgrammerListPresentation presenter) {
        this.presenter = presenter;
    }

    private List<ProgrammerResponse> processProgrammers(List<Programmer> programmers) {
        ArrayList<ProgrammerResponse> responses = new ArrayList<>();
        for (Programmer programmer : programmers) {
            responses.add(new ProgrammerResponse(programmer));
        }
        return responses;
    }
}
