package td.training.linkedinsenior.domain;

import td.training.linkedinsenior.domain.models.ProgrammerRequest;
import td.training.linkedinsenior.domain.use_cases.GetProgrammerDetailUseCase;
import td.training.linkedinsenior.domain.use_cases.SaveProgrammerUseCase;
import td.training.linkedinsenior.domain.use_cases.ShowProgrammersListUseCase;

import javax.inject.Inject;

public class UseCaseFactory {

    private EntityGateway mEntityGateway;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    @Inject
    public UseCaseFactory(EntityGateway entityGateway) {
        mEntityGateway = entityGateway;
    }
    //</editor-fold>

    //<editor-fold desc="Use case generation">
    public UseCase showProgrammersListUseCase(UseCase.MultipleProgrammerResponseHandler handler) {
        return new ShowProgrammersListUseCase(mEntityGateway, handler);
    }
    public UseCase saveProgrammerUseCase(ProgrammerRequest request, UseCase.CompletionHandler handler) {
        return new SaveProgrammerUseCase(mEntityGateway, request, handler);
    }

    public UseCase getProgrammerDetailUseCase(String id, UseCase.SingleProgrammerHandler programmerHandler) {
        return new GetProgrammerDetailUseCase(mEntityGateway, id, programmerHandler);
    }
}
