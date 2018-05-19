package travkina.vv.mygraduationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_1);
        Thread splash_time = new Thread()
        {
            public void run()
            {
                try
                {
                    int SplashTimer = 0;

                    while(SplashTimer < 1000) {
                        sleep(100);
                        SplashTimer = SplashTimer +100;
                    };
                    startActivity(new Intent(SecondActivity.this,MainActivityBasic.class));
                }
                catch (InterruptedException e) {
                    e.printStackTrace(); }
                finally {

                    finish();
                }
            }
        };
        splash_time.start();
    }
}
