package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.models.ProgrammerRequest;

import javax.inject.Inject;

public class SaveProgrammerUseCase {

    private EntityGateway entityGateway;

    @Inject
    public SaveProgrammerUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void save(ProgrammerRequest programmerRequest) {
        Programmer programmer = programmerRequest.generateProgrammer();
        entityGateway.createNewProgrammer(programmer);
    }
}
