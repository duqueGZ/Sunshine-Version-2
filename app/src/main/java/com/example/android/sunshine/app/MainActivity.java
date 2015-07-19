package com.example.android.sunshine.app;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private static final String TODAY_LABEL = "Today";
    private static final String CLOUDY_LABEL = "cloudy";
    private static final String SDF_PATTERN = "MMMM dd";
    private static final int WEATHER_ICON_WIDTH = 184;
    private static final int WEATHER_ICON_HEIGHT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //Set forecast date to a selected date. For example, today
            TextView dateField = (TextView) rootView.findViewById(R.id.dateField);
            SimpleDateFormat sdf = new SimpleDateFormat(MainActivity.SDF_PATTERN, new Locale("en"));
            Date today = new Date();
            String dateValue = MainActivity.TODAY_LABEL + ", " + sdf.format(today);
            dateField.setText(dateValue);

            //Set forecast maximum and minimum temperature values to the corresponding value
            TextView maxTempField = (TextView) rootView.findViewById(R.id.maxTempField);
            maxTempField.setText("25º");
            TextView minTempField = (TextView) rootView.findViewById(R.id.minTempField);
            minTempField.setText("10º");

            //Set forecast icon and label to the corresponding image and name
            //ImageView weatherIcon = (ImageView) rootView.findViewById(R.id.weatherIcon);
            //weatherIcon.setImageDrawable(this.getResources().getDrawable(R.drawable.cloudy_icon));
            TextView weatherLabel = (TextView) rootView.findViewById(R.id.weatherLabel);
            weatherLabel.setText(MainActivity.CLOUDY_LABEL);
            Drawable cloudyDrawable = this.getResources().getDrawable(R.drawable.cloudy_icon);
            Bitmap cloudyBitmap = ((BitmapDrawable) cloudyDrawable).getBitmap();
            Drawable weatherIcon = new BitmapDrawable(this.getResources(), Bitmap.createScaledBitmap(cloudyBitmap, MainActivity.WEATHER_ICON_WIDTH, MainActivity.WEATHER_ICON_HEIGHT, true));
            weatherLabel.setCompoundDrawablesWithIntrinsicBounds(null, weatherIcon, null, null);

            return rootView;
        }
    }
}
