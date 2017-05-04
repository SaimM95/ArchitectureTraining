package td.training.linkedinsenior.presentation.presenters;

import td.training.linkedinsenior.domain.models.ProgrammerResponse;
import td.training.linkedinsenior.domain.ProgrammerListPresentation;
import td.training.linkedinsenior.domain.use_cases.ShowProgrammersListUseCase;
import td.training.linkedinsenior.presentation.formatters.DateUtils;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

public class ProgrammersListPresenter implements ProgrammerListPresentation, Observer {

    private List<ProgrammerResponse> programmers;
    private WeakReference<ProgrammersListView> view;

    private ShowProgrammersListUseCase programmersListUseCase;
    private String mSelectedId;

    @Inject
    public ProgrammersListPresenter(ShowProgrammersListUseCase programmersListUseCase) {
        this.programmersListUseCase = programmersListUseCase;
    }

    public void setProgrammersListView(ProgrammersListView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void present(List<ProgrammerResponse> programmerResponses) {
        programmers = programmerResponses;
        if (view.get() != null) {
            view.get().refreshList();
        }
    }

    public void viewReady() {
        programmersListUseCase.showProgrammers();
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

    public void notifyProgrammersListChanged() {

    }
}
