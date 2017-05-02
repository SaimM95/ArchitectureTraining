package td.training.linkedinsenior;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ProgrammersListAdapter extends RecyclerView.Adapter<ProgrammersListAdapter.ProgrammerItemViewHolder> {

    private ProgrammersListPresenter presenter;

    public ProgrammersListAdapter(ProgrammersListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ProgrammerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.programmer_item_layout, parent, false);
        return new ProgrammerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammerItemViewHolder holder, int position) {
        presenter.configureCell(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getNumberOfProgrammers();
    }

    static class ProgrammerItemViewHolder extends RecyclerView.ViewHolder implements ProgrammerCellView {

        private TextView programmerName;
        private TextView programmerInterviewDate;
        private ToggleButton programmerFavoriteSwitch;

        public ProgrammerItemViewHolder(View itemView) {
            super(itemView);

            programmerName = (TextView) itemView.findViewById(R.id.name_text_view_programmer_item);
            programmerInterviewDate = (TextView) itemView.findViewById(R.id.interview_date_programmer_item);
            programmerFavoriteSwitch = (ToggleButton) itemView.findViewById(R.id
                .favorite_toggle_button_programmer_item);

        }

        @Override
        public void displayName(String name) {
            programmerName.setText(name);
        }

        @Override
        public void displayInterviewDate(String date) {
            programmerInterviewDate.setText(date);
        }

        @Override
        public void displayFavorite(boolean favorite) {
            programmerFavoriteSwitch.setEnabled(favorite);
        }
    }
}
