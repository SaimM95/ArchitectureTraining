package td.training.linkedinsenior.platform.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import td.training.linkedinsenior.R;
import td.training.linkedinsenior.platform.ApplicationServiceLocator;
import td.training.linkedinsenior.platform.dependency_injection.DaggerEntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.DaggerNewProgrammerComponent;
import td.training.linkedinsenior.platform.dependency_injection.EntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.NewProgrammerModule;
import td.training.linkedinsenior.presentation.formatters.RatingColor;
import td.training.linkedinsenior.presentation.presenters.NewProgrammerPresenter;
import td.training.linkedinsenior.presentation.presenters.NewProgrammerView;

import javax.inject.Inject;

public class NewProgrammerActivity extends AppCompatActivity implements NewProgrammerView {

    @Inject
    NewProgrammerPresenter presenter;

    // Views
    private EditText mNameEditText;
    private ToggleButton mFavoriteToggleButton;
    private CompoundButton.OnCheckedChangeListener mFavoriteCheckedChangeListener;
    private SeekBar mEmacsSeekBar;
    private TextView mEmacsTextView;
    private SeekBar mCaffeineSeekBar;
    private TextView mCaffeineTextView;
    private RatingBar mRprRatingBar;

    private MenuItem mSaveMenuItem;
    // TODO: Implement logic for this boolean
    private boolean mSaveMenuItemEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_programmer);

        initDependencies();
        prepareViews();

        presenter.viewReady();
    }

    private void initDependencies() {
        //        NewProgrammerConnector connector = new NewProgrammerConnector();
        //        connector.inject(this);

        ApplicationServiceLocator serviceProvider = (ApplicationServiceLocator)getApplication();

        DaggerNewProgrammerComponent.builder()
            .newProgrammerModule(new NewProgrammerModule())
            .entityGatewayComponent(serviceProvider.getEntityGatewayComponent())
            .build()
            .inject(this);

        presenter.setView(this);
    }

    public void setPresenter(NewProgrammerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_programmer_edit, menu);
        mSaveMenuItem = menu.findItem(R.id.menu_item_save);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mSaveMenuItem.setEnabled(mSaveMenuItemEnabled);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean processed = false;
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                presenter.save();
                // close activity after clicking save
                setResult(999);
                finish();
                processed = true;
                break;
            case android.R.id.home:
                processed = true;
                break;
            default:

        }

        return (processed || super.onOptionsItemSelected(item));
    }

    public static void openForResult(Activity from, int requestCode) {
        from.startActivityForResult(new Intent(from, NewProgrammerActivity.class), requestCode);
    }

    // Prepare views

    private void prepareViews() {
        prepareNameEditText();
        prepareFavoriteToggleButton();
        prepareEmacsSeekBar();
        prepareEmacsTextView();
        prepareCaffeineSeekBar();
        prepareCaffeineTextView();
        prepareRprRatingBar();
    }

    private void prepareNameEditText() {
        mNameEditText = (EditText)findViewById(R.id.name_edit_text_programmer_edit);
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updateName(editable.toString());
            }
        });
    }

    private void prepareFavoriteToggleButton() {
        mFavoriteToggleButton = (ToggleButton)findViewById(R.id.favorite_toggle_button_programmer_edit);
        mFavoriteToggleButton.setEnabled(true);
        //        mFavoriteToggleButton.setChecked(true);
        mFavoriteCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                presenter.updateFavorite(b);
            }
        };
        mFavoriteToggleButton.setOnCheckedChangeListener(mFavoriteCheckedChangeListener);
    }

    private void prepareEmacsSeekBar() {
        mEmacsSeekBar = (SeekBar)findViewById(R.id.emacs_seek_bar_programmer_edit);
        mEmacsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                presenter.updateEmacs(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void prepareEmacsTextView() {
        mEmacsTextView = (TextView)findViewById(R.id.emacs_text_view_programmer_edit);
    }

    private void prepareCaffeineSeekBar() {
        mCaffeineSeekBar = (SeekBar)findViewById(R.id.caffeine_seek_bar_programmer_edit);
        mCaffeineSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                presenter.updateCaffeine(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void prepareCaffeineTextView() {
        mCaffeineTextView = (TextView)findViewById(R.id.caffeine_text_view_programmer_edit);
    }

    private void prepareRprRatingBar() {
        mRprRatingBar = (RatingBar)findViewById(R.id.rpr_rating_bar_programmer_edit);
    }

    @Override
    public void updateSaveButton(boolean isEnabled) {
        mSaveMenuItemEnabled = isEnabled;
    }

    @Override
    public void setCaffeine(int caffeine) {
        mCaffeineSeekBar.setProgress(caffeine);
    }

    @Override
    public void setEmacs(int emacs) {
        mEmacsSeekBar.setProgress(emacs);
    }

    @Override
    public void setRealProgrammerRating(int rating) {
        // +1 to convert 0-4 to 1-5
        mRprRatingBar.setProgress(rating + 1);
        LayerDrawable stars = (LayerDrawable)mRprRatingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(RatingColor.getColor(rating), PorterDuff.Mode.SRC_ATOP);
    }
}
