package td.training.linkedinsenior;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProgrammersListPresenter implements ProgrammerListPresentation {

    private List<ProgrammerResponse> programmers;
    private ShowProgrammersListUseCase programmersListUseCase;

    public ProgrammersListPresenter(ShowProgrammersListUseCase programmersListUseCase) {
        this.programmersListUseCase = programmersListUseCase;
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

    private String formatDate(Date date) {
        DateUtils dateUtils = new DateUtils(date);
        return dateUtils.formatDate(Calendar.getInstance().getTime());
    }
}
