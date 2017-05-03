package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.use_cases.ShowProgrammersListUseCase;
import td.training.linkedinsenior.presentation.presenters.ProgrammersListPresenter;

@Module
public class ProgrammersListModule {

    @Provides ProgrammersListPresenter providesProgrammersListPresenter(ShowProgrammersListUseCase useCase) {
        ProgrammersListPresenter presenter = new ProgrammersListPresenter(useCase);
        useCase.setPresenter(presenter);
        return presenter;
    }

    @Provides
    ShowProgrammersListUseCase providesShowProgrammersListUseCase(EntityGateway entityGateway) {
        return new ShowProgrammersListUseCase(entityGateway);
    }

}
