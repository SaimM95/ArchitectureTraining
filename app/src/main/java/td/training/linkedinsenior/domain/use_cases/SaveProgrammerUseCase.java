package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.IdentityGenerator;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.models.ProgrammerRequest;
import td.training.linkedinsenior.domain.models.UUIDIdentityGenerator;

import javax.inject.Inject;

public class SaveProgrammerUseCase {

    private EntityGateway entityGateway;
    private IdentityGenerator mIdentityGenerator;

    @Inject
    public SaveProgrammerUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public void save(ProgrammerRequest programmerRequest) {
        Programmer programmer = programmerRequest.generateProgrammer(identityGenerator().getId());
        entityGateway.createNewProgrammer(programmer);
    }

    private IdentityGenerator identityGenerator() {
        if (mIdentityGenerator == null) {
            mIdentityGenerator = new UUIDIdentityGenerator();
        }
        return mIdentityGenerator;
    }
}
