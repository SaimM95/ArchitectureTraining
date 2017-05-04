package td.training.linkedinsenior.presentation.presenters;

import android.text.TextUtils;
import android.widget.Toast;

import td.training.linkedinsenior.domain.models.ProgrammerRequest;
import td.training.linkedinsenior.domain.models.ProgrammerResponse;
import td.training.linkedinsenior.domain.use_cases.SaveProgrammerUseCase;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

public class NewProgrammerPresenter implements Observer {

    private SaveProgrammerUseCase useCase;
    private WeakReference<NewProgrammerView> view;
    private ProgrammerRequest mProgrammerRequest;

    @Inject
    public NewProgrammerPresenter(SaveProgrammerUseCase useCase) {
        this.useCase = useCase;

        mProgrammerRequest = new ProgrammerRequest();
        mProgrammerRequest.addObserver(this);
    }

    public void viewReady() {
        if (view.get() != null) {
            view.get().setCaffeine(mProgrammerRequest.getCaffeine());
            view.get().setEmacs(mProgrammerRequest.getEmacs());
        }
    }

    public void save() {
        useCase.save(mProgrammerRequest);
    }

    public void setView(NewProgrammerView view) {
        this.view = new WeakReference<>(view);
    }

    public void updateName(String name) {
        mProgrammerRequest.setName(name);
    }

    public void updateEmacs(int emacs) {
        mProgrammerRequest.setEmacs(emacs);
    }

    public void updateCaffeine(int caffeine) {
        mProgrammerRequest.setCaffeine(caffeine);
    }

    public void updateFavorite(boolean favorite) {
        mProgrammerRequest.setFavorite(favorite);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (view.get() != null) {
            String name = mProgrammerRequest.getName();
            view.get().updateSaveButton(name != null && !TextUtils.isEmpty(name));
            view.get().setRealProgrammerRating(mProgrammerRequest.getRealProgrammerRating());
        }
    }
}
