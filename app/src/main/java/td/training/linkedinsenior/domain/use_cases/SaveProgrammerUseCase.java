package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.IdentityGenerator;
import td.training.linkedinsenior.domain.UseCase;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.models.ProgrammerRequest;
import td.training.linkedinsenior.domain.models.UUIDIdentityGenerator;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class SaveProgrammerUseCase implements UseCase {

    @Inject EntityGateway entityGateway;
    private IdentityGenerator mIdentityGenerator;
    private ProgrammerRequest mProgrammerRequest;
    private WeakReference<CompletionHandler> mHandler;

    public SaveProgrammerUseCase(EntityGateway entityGateway, ProgrammerRequest programmerRequest, CompletionHandler
        handler) {
        this.entityGateway = entityGateway;
        mProgrammerRequest = programmerRequest;
        mHandler = new WeakReference<>(handler);
    }

    private IdentityGenerator identityGenerator() {
        if (mIdentityGenerator == null) {
            mIdentityGenerator = new UUIDIdentityGenerator();
        }
        return mIdentityGenerator;
    }

    @Override
    public void execute() {
        Programmer programmer = mProgrammerRequest.generateProgrammer(identityGenerator().getId());
        entityGateway.createNewProgrammer(programmer);
        if (mHandler.get() != null) {
            mHandler.get().handleCompletion();
        }
    }
}
