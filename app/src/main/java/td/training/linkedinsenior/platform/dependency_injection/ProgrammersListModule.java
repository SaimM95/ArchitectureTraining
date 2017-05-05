package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.UseCaseFactory;
import td.training.linkedinsenior.presentation.presenters.ProgrammersListPresenter;

import java.util.Observable;

@Module
public class ProgrammersListModule {

    @Provides ProgrammersListPresenter providesProgrammersListPresenter(UseCaseFactory useCase) {
        return new ProgrammersListPresenter(useCase);
    }

    @Provides Observable providesEntityGatewayObservable(InMemoryRepo repo) {
        return repo;
    }

}
