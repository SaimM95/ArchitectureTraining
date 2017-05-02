package td.training.linkedinsenior;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

public class ProgrammersListActivity extends AppCompatActivity implements ProgrammersListView {

    @Inject
    ProgrammersListPresenter presenter;

    private ProgrammersListConnector connector;

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

    private void initDependencies() {
        connector = new ProgrammersListConnector();

        EntityGatewayComponent entityGateway = DaggerEntityGatewayComponent.builder()
            .build();

        DaggerProgrammersListComponent.builder()
            .programmersListModule(new ProgrammersListModule())
            .entityGatewayComponent(entityGateway)
            .build()
            .inject(this);
    }

    private void initView() {
        if (presenter == null) {
            return;
        }

        presenter.viewReady();

        RecyclerView programmersListView = (RecyclerView)findViewById(R.id.programmers_list_view);
        ProgrammersListAdapter programmersListAdapter = new ProgrammersListAdapter(presenter);

        programmersListView.setLayoutManager(new LinearLayoutManager(this));
        programmersListView.setAdapter(programmersListAdapter);
    }

    public void setPresenter(ProgrammersListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToNewProgrammerActivity() {
        connector.openNewProgrammerActivity(this);
    }
}
