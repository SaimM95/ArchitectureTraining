package td.training.linkedinsenior;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ProgrammersListActivity extends AppCompatActivity {

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });

        initView();
    }

    private void initView() {
        RecyclerView programmersListView = (RecyclerView) findViewById(R.id.programmers_list_view);

        InMemoryRepo entityGateway = new InMemoryRepo();
        ShowProgrammersListUseCase programmersListUseCase = new ShowProgrammersListUseCase(entityGateway);
        ProgrammersListPresenter presenter = new ProgrammersListPresenter(programmersListUseCase);
        programmersListUseCase.setPresenter(presenter);

        ProgrammersListAdapter programmersListAdapter = new ProgrammersListAdapter(presenter);

        programmersListView.setLayoutManager(new LinearLayoutManager(this));
        programmersListView.setAdapter(programmersListAdapter);

        presenter.viewReady();
    }

}
