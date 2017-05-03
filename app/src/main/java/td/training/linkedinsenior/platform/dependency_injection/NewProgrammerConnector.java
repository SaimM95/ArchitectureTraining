package td.training.linkedinsenior.platform.dependency_injection;

import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.use_cases.SaveProgrammerUseCase;
import td.training.linkedinsenior.platform.views.NewProgrammerActivity;
import td.training.linkedinsenior.presentation.presenters.NewProgrammerPresenter;

public class NewProgrammerConnector {

    public void inject(NewProgrammerActivity activity) {
        InMemoryRepo entityGateway = new InMemoryRepo();
        SaveProgrammerUseCase useCase = new SaveProgrammerUseCase(entityGateway);

        NewProgrammerPresenter presenter = new NewProgrammerPresenter(useCase);
//        useCase.setPresenter(presenter);
        presenter.setView(activity);

        activity.setPresenter(presenter);
    }
}
