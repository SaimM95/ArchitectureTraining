package td.training.linkedinsenior;

import android.app.Activity;

public class ProgrammersListConnector {

    public void inject(ProgrammersListActivity activity) {
        InMemoryRepo entityGateway = new InMemoryRepo();
        ShowProgrammersListUseCase programmersListUseCase = new ShowProgrammersListUseCase(entityGateway);

        ProgrammersListPresenter presenter = new ProgrammersListPresenter(programmersListUseCase);
        programmersListUseCase.setPresenter(presenter);
        presenter.setProgrammersListView(activity);

        activity.setPresenter(presenter);
    }

    public void openNewProgrammerActivity(Activity from) {
        NewProgrammerActivity.open(from);
    }
}
