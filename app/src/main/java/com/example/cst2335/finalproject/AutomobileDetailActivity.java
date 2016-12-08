package com.example.cst2335.finalproject;

/**
 * Created by wanno on 2016-12-04.
 */

        import android.content.res.Configuration;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;

public class AutomobileDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the device is in landscape mode
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        // Check if we have any hero data saved
        if (savedInstanceState == null) {

            // If not then create the DetailsFragment
            AutomobileDetailFragment details = new AutomobileDetailFragment();

            // Get the Bundle of key value pairs and assign them to the DetailsFragment
            details.setArguments(getIntent().getExtras());

            // Add the details Fragment
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
}