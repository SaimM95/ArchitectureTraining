package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.models.ProgrammerRequest;
import td.training.linkedinsenior.domain.models.ProgrammerResponse;

public class SaveProgrammerUseCase {

    private EntityGateway entityGateway;

    public SaveProgrammerUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void save(ProgrammerRequest programmer) {

    }
}
