package td.training.linkedinsenior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewProgrammerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_programmer);
    }

    public static void open(Activity from) {
        from.startActivity(new Intent(from, NewProgrammerActivity.class));
    }
}
