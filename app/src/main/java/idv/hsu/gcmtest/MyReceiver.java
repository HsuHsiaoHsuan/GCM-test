package idv.hsu.gcmtest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class MyReceiver extends WakefulBroadcastReceiver {
    private static final String TAG = MyReceiver.class.getSimpleName();


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "MyReceiver.onReceive" + intent.getAction());
        ComponentName comp = new ComponentName(context.getPackageName(), MyReceiver.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}
