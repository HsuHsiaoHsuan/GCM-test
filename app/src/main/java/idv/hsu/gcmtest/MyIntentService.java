package idv.hsu.gcmtest;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MyIntentService extends IntentService {
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        if ( gcm != null) {
            StringBuilder log = new StringBuilder();
            log.append("MessageType: ").append(gcm.getMessageType(intent));
            if (!extras.isEmpty()) {
                log.append("\n").append("Extras: ").append(extras.toString());
            }
            Log.d(TAG, log.toString());
        }
        MyReceiver.completeWakefulIntent(intent);
    }
}
