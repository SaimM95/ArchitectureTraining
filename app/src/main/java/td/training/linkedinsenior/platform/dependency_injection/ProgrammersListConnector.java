package td.training.linkedinsenior.platform.dependency_injection;

import android.app.Activity;

import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.use_cases.ShowProgrammersListUseCase;
import td.training.linkedinsenior.platform.views.NewProgrammerActivity;
import td.training.linkedinsenior.platform.views.ProgrammersListActivity;
import td.training.linkedinsenior.presentation.presenters.ProgrammersListPresenter;

public class ProgrammersListConnector {

//    public void inject(ProgrammersListActivity activity) {
//        InMemoryRepo entityGateway = new InMemoryRepo();
//        ShowProgrammersListUseCase programmersListUseCase = new ShowProgrammersListUseCase(entityGateway);
//
//        ProgrammersListPresenter presenter = new ProgrammersListPresenter(programmersListUseCase);
//        programmersListUseCase.setPresenter(presenter);
//        presenter.setProgrammersListView(activity);
//
//        activity.setPresenter(presenter);
//    }

    public void openNewProgrammerActivity(Activity from) {
        NewProgrammerActivity.open(from);
    }
}
