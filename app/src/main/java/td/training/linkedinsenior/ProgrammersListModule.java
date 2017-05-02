package td.training.linkedinsenior;

import dagger.Module;
import dagger.Provides;

@Module
public class ProgrammersListModule {

    @Provides ProgrammersListPresenter providesProgrammersListPresenter(ShowProgrammersListUseCase useCase) {
        ProgrammersListPresenter presenter = new ProgrammersListPresenter(useCase);
        useCase.setPresenter(presenter);
        return presenter;
    }

    @Provides ShowProgrammersListUseCase providesShowProgrammersListUseCase(EntityGateway entityGateway) {
        return new ShowProgrammersListUseCase(entityGateway);
    }

}
