package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.UseCaseFactory;
import td.training.linkedinsenior.presentation.presenters.NewProgrammerPresenter;

@Module
public class NewProgrammerModule {
    @Provides
    NewProgrammerPresenter providesNewProgrammerPresenter(UseCaseFactory useCase) {
        return new NewProgrammerPresenter(useCase);
    }
}
