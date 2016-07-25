package saidul.com.andriodserviceandsimplemediaexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyMediaPlayerService extends Service implements MediaPlayer.OnInfoListener {

    public static final String TAG = MyMediaPlayerService.class.getName();
    MediaPlayer mediaPlayer;
    public MyMediaPlayerService() {
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int intExtra = intent.getIntExtra(MainActivity.KEY_SONG_ID, 0);
        mediaPlayer = MediaPlayer.create(this, intExtra);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        mediaPlayer.setOnInfoListener(this);
        // NO NEED TO AUTO START
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        stopSelf();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {

        Log.e(TAG, "i "+i+" i1"+i1);
        return false;
    }
}
