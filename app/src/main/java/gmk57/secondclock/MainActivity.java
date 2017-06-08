package gmk57.secondclock;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * My first own project: very simple clock with seconds (which I missed on my phone).
 * Just to start with something.
 */

public class MainActivity extends Activity implements Runnable {
    private TextView mClockTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClockTextView = (TextView) findViewById(R.id.clock_text_view);
        adjustSize();
    }

    /**
     * Adjusts text size to approximately fit the screen
     */
    private void adjustSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int textSize = displayMetrics.widthPixels / 6;
        mClockTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    @Override
    protected void onStart() {
        super.onStart();
        run();
    }

    @Override
    protected void onStop() {
        mClockTextView.removeCallbacks(this);
        super.onStop();
    }

    @Override
    public void run() {
        mClockTextView.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date()));
        mClockTextView.postDelayed(this, 1000);
    }
}
