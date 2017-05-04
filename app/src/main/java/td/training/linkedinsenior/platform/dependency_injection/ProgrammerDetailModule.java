package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.use_cases.GetProgrammerDetailUseCase;
import td.training.linkedinsenior.presentation.presenters.ProgrammerDetailPresenter;

@Module
public class ProgrammerDetailModule {

    private String mId;

    public ProgrammerDetailModule(String id) {
        mId = id;
    }

    @Provides
    ProgrammerDetailPresenter providesProgrammerDetailPresenter(GetProgrammerDetailUseCase useCase) {
        ProgrammerDetailPresenter presenter = new ProgrammerDetailPresenter(useCase, mId);
        // TODO: add usecase.setpresenter
        return presenter;
    }
}
