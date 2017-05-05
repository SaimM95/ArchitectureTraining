package td.training.linkedinsenior.presentation.presenters;

import td.training.linkedinsenior.domain.UseCase;
import td.training.linkedinsenior.domain.models.Programmer;
import td.training.linkedinsenior.domain.UseCaseFactory;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class ProgrammerDetailPresenter implements UseCase.SingleProgrammerHandler {

    private UseCaseFactory mUseCase;
    private String mProgrammerId;
    private WeakReference<ProgrammerDetailView> mView;

    @Inject
    public ProgrammerDetailPresenter(UseCaseFactory useCase, String programmerId) {
        mUseCase = useCase;
        mProgrammerId = programmerId;
    }

    public void viewReady() {
        UseCase detailUseCase = mUseCase.getProgrammerDetailUseCase(mProgrammerId, this);
        detailUseCase.execute();
    }

    public void setView(ProgrammerDetailView view) {
        mView = new WeakReference<>(view);
    }

    public String getId() {
        return mProgrammerId;
    }

    @Override
    public void handleSingleProgrammer(Programmer programmer) {
        if (mView.get() != null) {
            mView.get().displayName(programmer.getName());
            mView.get().displayCaffeine(Integer.toString(programmer.getCaffeine()));
            mView.get().displayEmacs(Integer.toString(programmer.getEmacs()));
            mView.get().displayRealProgrammerRating(programmer.getRealProgrammerRating());
            mView.get().setUpFavorite(programmer.isFavorite());
        }
    }
}
