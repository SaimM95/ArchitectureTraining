package td.training.linkedinsenior.platform.dependency_injection;

import android.app.Activity;
import android.content.Intent;

import td.training.linkedinsenior.platform.views.NewProgrammerActivity;
import td.training.linkedinsenior.platform.views.ProgrammerDetailActivity;

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
        NewProgrammerActivity.openForResult(from, 999);
    }

    public void openProgrammerDetailActivity(Activity from, String id) {
        if (from != null) {
            Intent intent = new Intent(from, ProgrammerDetailActivity.class);
            intent.putExtra(ProgrammerDetailActivity.EXTRA_PROGRAMMER_ID, id);
            ProgrammerDetailActivity.open(from, intent);
        }
    }
}
