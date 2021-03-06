package td.training.linkedinsenior.platform.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import td.training.linkedinsenior.platform.ApplicationServiceLocator;
import td.training.linkedinsenior.platform.RealProgrammerApplication;
import td.training.linkedinsenior.platform.dependency_injection.DaggerEntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.DaggerProgrammersListComponent;
import td.training.linkedinsenior.platform.dependency_injection.EntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.EntityGatewayModule;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammersListConnector;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammersListModule;
import td.training.linkedinsenior.presentation.presenters.ProgrammersListPresenter;
import td.training.linkedinsenior.presentation.presenters.ProgrammersListView;
import td.training.linkedinsenior.R;

import javax.inject.Inject;

public class ProgrammersListActivity extends AppCompatActivity implements ProgrammersListView {

    @Inject
    ProgrammersListPresenter presenter;

    private ProgrammersListConnector connector;
    private RecyclerView programmersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmers_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //                    .setAction("Action", null).show();
                presenter.performFabAction();
            }
        });

        initDependencies();
        initView();
    }

    // 3 ways to retain data when activity is destroyed (e.g. screen orientation change)

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        // #1 Store data as bundle and retrieve in onCreate
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        // #2 store one reference to an object and retrieve at beginning of onCreate
        return super.onRetainCustomNonConfigurationInstance();
    }

    // #3 Use FragmentManager.setRetain which is retained even when Activity is destroyed

    private void initDependencies() {
        connector = new ProgrammersListConnector();

        ApplicationServiceLocator serviceProvider = (ApplicationServiceLocator)getApplication();
        serviceProvider.getProgrammersListComponent().inject(this);

        presenter.setProgrammersListView(this);
    }

    private void initView() {
        if (presenter == null) {
            return;
        }

        presenter.viewReady();

        programmersListView = (RecyclerView)findViewById(R.id.programmers_list_view);
        final ProgrammersListAdapter programmersListAdapter = new ProgrammersListAdapter(presenter);

        programmersListView.setLayoutManager(new LinearLayoutManager(this));
        programmersListView.setAdapter(programmersListAdapter);

        programmersListView.addOnItemTouchListener(
            new RecyclerItemClickListener(this, programmersListView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {
                    presenter.select(position);
                }

                @Override public void onLongItemClick(View view, int position) {
                }
            })
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999) {
            presenter.viewReady();
        }
    }

    public void setPresenter(ProgrammersListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToNewProgrammerActivity() {
        connector.openNewProgrammerActivity(this);
    }

    @Override
    public void navigateToProgrammerDetail() {
        connector.openProgrammerDetailActivity(this, presenter.getId());
    }

    @Override
    public void refreshList() {
        if (programmersListView != null) {
            programmersListView.getAdapter().notifyDataSetChanged();
        }
    }
}
