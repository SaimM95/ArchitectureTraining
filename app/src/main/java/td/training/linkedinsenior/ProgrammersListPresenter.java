package td.training.linkedinsenior;

import java.util.List;

public class ProgrammersListPresenter implements ProgrammerListPresentation {

    private int numberOfProgrammers;

    @Override
    public void present(List<ProgrammerResponse> programmerResponses) {

    }

    public void viewReady() {

    }

    public int getNumberOfProgrammers() {
        return numberOfProgrammers;
    }

    public void configureCell(int position, ProgrammerCellView view) {

    }
}
