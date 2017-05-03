package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.use_cases.SaveProgrammerUseCase;
import td.training.linkedinsenior.presentation.presenters.NewProgrammerPresenter;

@Module
public class NewProgrammerModule {
    @Provides
    NewProgrammerPresenter providesNewProgrammerPresenter(SaveProgrammerUseCase useCase) {
        NewProgrammerPresenter presenter = new NewProgrammerPresenter(useCase);
        return presenter;
    }

    @Provides SaveProgrammerUseCase providesSaveProgrammerUseCase(EntityGateway entityGateway) {
        return new SaveProgrammerUseCase(entityGateway);
    }
}
