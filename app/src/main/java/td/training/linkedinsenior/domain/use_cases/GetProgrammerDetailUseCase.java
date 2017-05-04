package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.ProgrammerListPresentation;

import javax.inject.Inject;

public class GetProgrammerDetailUseCase {

    private EntityGateway entityGateway;


    @Inject
    public GetProgrammerDetailUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void getProgrammer(String id) {

    }

    public void setPresenter(ProgrammerListPresentation presenter) {
//        this.presenter = new WeakReference<>(presenter);
    }

}
