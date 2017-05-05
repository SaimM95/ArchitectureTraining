package td.training.linkedinsenior.presentation.presenters;

import td.training.linkedinsenior.domain.UseCase;
import td.training.linkedinsenior.domain.models.ProgrammerResponse;
import td.training.linkedinsenior.domain.UseCaseFactory;
import td.training.linkedinsenior.presentation.formatters.DateUtils;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

public class ProgrammersListPresenter implements Observer, UseCase.MultipleProgrammerResponseHandler {

    private List<ProgrammerResponse> programmers;
    private WeakReference<ProgrammersListView> view;

    private UseCaseFactory useCase;
    private UseCase showProgrammersUseCase;
    private String mSelectedId;

    @Inject
    public ProgrammersListPresenter(UseCaseFactory useCase) {
        this.useCase = useCase;
    }

    public void setProgrammersListView(ProgrammersListView view) {
        this.view = new WeakReference<>(view);
    }

    public void viewReady() {
        // Can pass in a lambda function instead of "this" then we don't have to handle the callback in the presenter
        showProgrammersUseCase = useCase.showProgrammersListUseCase(this);
        showProgrammersUseCase.execute();
    }

    public int getNumberOfProgrammers() {
        return programmers == null ? 0 : programmers.size();
    }

    public void configureCell(int position, ProgrammerCellView view) {
        String name = programmers.get(position).getName();
        String interviewDate = formatDate(programmers.get(position).getInterviewDate());
        boolean favorite = programmers.get(position).isFavorite();

        view.displayName(name);
        view.displayInterviewDate(interviewDate);
        view.displayFavorite(favorite);
    }

    public void performFabAction() {
        if (view.get() != null) {
            view.get().navigateToNewProgrammerActivity();
        }
    }

    public void select(int itemPosition) {
        ProgrammersListView mView = view.get();
        if (mView != null) {
            if ((itemPosition >= 0) && (itemPosition < programmers.size())) {
                ProgrammerResponse programmer = programmers.get(itemPosition);
                mSelectedId = programmer.getId();
                mView.navigateToProgrammerDetail();
            } else {
                mSelectedId = null;
            }
        }
    }

    public String getId() {
        return mSelectedId;
    }

    private String formatDate(Date date) {
        DateUtils dateUtils = new DateUtils(date);
        return dateUtils.formatDate(Calendar.getInstance().getTime());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void handleMultipleProgrammerResponses(List<ProgrammerResponse> programmers) {
        this.programmers = programmers;
        if (view.get() != null) {
            view.get().refreshList();
        }

        // Reset the usecase
        showProgrammersUseCase = null;
    }

    //    @Override
//    public void handleMultipleProgrammerResponses(List<ProgrammerResponse> programmers) {
//        this.programmers = programmers;
//        if (view.get() != null) {
//            view.get().refreshList();
//        }
//    }
}
