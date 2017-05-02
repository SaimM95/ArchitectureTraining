package td.training.linkedinsenior;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class ProgrammersListPresenter implements ProgrammerListPresentation {

    private List<ProgrammerResponse> programmers;
    private WeakReference<ProgrammersListView> view;

    private ShowProgrammersListUseCase programmersListUseCase;

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

    private String formatDate(Date date) {
        DateUtils dateUtils = new DateUtils(date);
        return dateUtils.formatDate(Calendar.getInstance().getTime());
    }
}
