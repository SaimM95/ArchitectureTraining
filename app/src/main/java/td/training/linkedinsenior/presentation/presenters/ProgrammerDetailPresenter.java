package td.training.linkedinsenior.presentation.presenters;

import td.training.linkedinsenior.domain.ProgrammerDetailPresentation;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.use_cases.GetProgrammerDetailUseCase;

import javax.inject.Inject;

public class ProgrammerDetailPresenter implements ProgrammerDetailPresentation{

    private GetProgrammerDetailUseCase mUseCase;
    private String mProgrammerId;

    @Inject
    public ProgrammerDetailPresenter(GetProgrammerDetailUseCase useCase, String programmerId) {
        mUseCase = useCase;
        mProgrammerId = programmerId;
    }

    public void viewReady() {

    }

    public String getId() {
        return mProgrammerId;
    }

    @Override
    public void present(Programmer programmer) {

    }
}
