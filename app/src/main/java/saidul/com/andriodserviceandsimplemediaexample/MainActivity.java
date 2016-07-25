package saidul.com.andriodserviceandsimplemediaexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_SONG_ID = "KEY_SONG_ID";
    private android.widget.Button btStart;
    private android.widget.Button btStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btStop = (Button) findViewById(R.id.btStop);
        this.btStart = (Button) findViewById(R.id.btStart);
        btStart.setOnClickListener(this);
        btStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btStart:
                Intent intent = new Intent(this, MyMediaPlayerService.class);
                intent.putExtra(KEY_SONG_ID, R.raw.hello);
                startService(intent);


                break;
            case R.id.btStop:
                Intent intentStop = new Intent(this, MyMediaPlayerService.class);
                stopService(intentStop);



                break;

        }
    }
}
