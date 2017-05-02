package td.training.linkedinsenior;

import java.util.ArrayList;
import java.util.List;

public class ShowProgrammersListUseCase {

    private EntityGateway entityGateway;
    private ProgrammerListPresentation presenter;

    public ShowProgrammersListUseCase(EntityGateway entityGateway, ProgrammerListPresentation presenter) {
        this.entityGateway = entityGateway;
        this.presenter = presenter;
    }

    public void showProgrammersList() {
        // 1. grab data from persistance
        List<Programmer> programmers = entityGateway.fetchProgrammers();

        // 2. process data
        List<ProgrammerResponse> responses = processProgrammers(programmers);

        // 3. pass it to presenter
        presenter.present(responses);
    }

    private List<ProgrammerResponse> processProgrammers(List<Programmer> programmers) {
        ArrayList<ProgrammerResponse> responses = new ArrayList<>();
        for (Programmer programmer : programmers) {
            responses.add(new ProgrammerResponse(programmer));
        }
        return responses;
    }
}
