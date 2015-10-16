package idv.hsu.gcmtest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String PROJECT_NUMBER = "electric-signal-109919";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void registerInBackground(final Context context) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Log.d(TAG, "Start GCM regist");
                try {
                    GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
                    if (gcm != null) {
                        String regId = gcm.register(PROJECT_NUMBER);
                        Log.d(TAG, "regist over, regid:" + regId);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                return null;
            }
        }.execute(null, null, null);
    }
}
