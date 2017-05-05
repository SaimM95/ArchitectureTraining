package td.training.linkedinsenior.domain.use_cases;

import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.UseCase;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class GetProgrammerDetailUseCase implements UseCase {

    @Inject EntityGateway entityGateway;
    private String mId;
    private WeakReference<SingleProgrammerHandler> mHandler;

    public GetProgrammerDetailUseCase(EntityGateway entityGateway, String id, SingleProgrammerHandler handler) {
        this.entityGateway = entityGateway;
        mId = id;
        mHandler = new WeakReference<>(handler);
    }

    @Override
    public void execute() {
        if (mHandler.get() != null) {
            mHandler.get().handleSingleProgrammer(entityGateway.fetchProgrammer(mId));
        }
    }
}
