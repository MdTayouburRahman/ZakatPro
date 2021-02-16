package droidrocks.com.zakatpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SpalashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash_screen);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
                Intent intent = new Intent(SpalashScreenActivity.this,MainActivity.class);
                startActivity(intent);


            }
        },3000);

    }
}