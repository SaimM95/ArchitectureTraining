package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.UseCaseFactory;
import td.training.linkedinsenior.presentation.presenters.ProgrammerDetailPresenter;

@Module
public class ProgrammerDetailModule {

    private String mId;

    public ProgrammerDetailModule(String id) {
        mId = id;
    }

    @Provides
    ProgrammerDetailPresenter providesProgrammerDetailPresenter(UseCaseFactory useCase) {
        return new ProgrammerDetailPresenter(useCase, mId);
    }
}
