package panic.com.panicbuttonalpha;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //masuk ke activity lain
                //setelah splash berjalan
                //Intent intent = new Intent(this, MainActivity.class);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },100);
    }


}