package td.training.linkedinsenior.platform.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import td.training.linkedinsenior.R;
import td.training.linkedinsenior.platform.ApplicationServiceLocator;
import td.training.linkedinsenior.presentation.presenters.ProgrammerDetailPresenter;
import td.training.linkedinsenior.presentation.presenters.ProgrammerDetailView;

import javax.inject.Inject;

public class ProgrammerDetailActivity extends AppCompatActivity implements ProgrammerDetailView {

    public static final String EXTRA_PROGRAMMER_ID = "td.training.linkedinsenior.programmer_id";

    @Inject
    ProgrammerDetailPresenter presenter;

    private CompoundButton mFavoriteToggleButton;
    private CompoundButton.OnCheckedChangeListener mFavoriteCheckedChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wireUpViews();
//        assembleModule();
        injectDependencies();

        if (presenter != null) {
            presenter.viewReady();
        }
    }

    private void injectDependencies() {
        String id = getIntent().getStringExtra(EXTRA_PROGRAMMER_ID);
        ApplicationServiceLocator serviceProvider = (ApplicationServiceLocator)getApplication();
        serviceProvider.getProgrammerDetailComponent(id).inject(this);

        presenter.setView(this);
    }

//    private void assembleModule() {
//        String id = getIntent().getStringExtra(EXTRA_PROGRAMMER_ID);
//        if (id != null) {
//            Toast.makeText(this, "Id is " + id, Toast.LENGTH_SHORT).show();
//        }
//    }

    public static void open(Activity from, Intent intent) {
        from.startActivity(intent);
    }

    private void wireUpViews() {
        prepareFavoriteToggleButton();
    }

    private void prepareFavoriteToggleButton() {
        mFavoriteToggleButton = (ToggleButton) findViewById(R.id.favorite_toggle_button_programmer_detail);
        mFavoriteCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        };
        mFavoriteToggleButton.setOnCheckedChangeListener(mFavoriteCheckedChangeListener);
    }

    @Override
    public void displayName(String name) {
        TextView nameTextView = (TextView)findViewById(R.id.name_text_view_programmer_detail);
        nameTextView.setText(name);
    }

    @Override
    public void setUpFavorite(Boolean favorite) {
        mFavoriteToggleButton.setOnCheckedChangeListener(null);
        mFavoriteToggleButton.setChecked(favorite);
        mFavoriteToggleButton.setOnCheckedChangeListener(mFavoriteCheckedChangeListener);
    }

    @Override
    public void displayEmacs(String emacsLabel) {
        TextView emacsTextView = (TextView)findViewById(R.id.emacs_text_view_programmer_detail);
        emacsTextView.setText(emacsLabel);
    }

    @Override
    public void displayCaffeine(String caffeineLabel) {
        TextView caffeineTextView = (TextView)findViewById(R.id.caffeine_text_view_programmer_detail);
        caffeineTextView.setText(caffeineLabel);
    }

    @Override
    public void displayRealProgrammerRating(Integer value) {
        RatingBar rprRatingBar = (RatingBar)findViewById(R.id.rpr_rating_bar_programmer_detail);
        rprRatingBar.setRating(value + 1f);
//        LayerDrawable stars = (LayerDrawable)rprRatingBar.getProgressDrawable();
//        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(this, colorCode), PorterDuff.Mode.SRC_ATOP);
    }


}
