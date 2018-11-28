package panic.com.panicbuttonalpha;

//HELLO CSIRT v.0.1
//2,3,4 September 2018
//program panic button utama
//user klik tombol
//user langsung terhubung dengan servicedesk
//update 12 September
//cannot resolve symbol diselesaikan dengan menghapus .idea pada folder app
//update: memasukkan id cuma sekali

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Formatter;

import panic.com.panicbuttonalpha.R;

import static android.Manifest.permission.CALL_PHONE;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String nT = "088211130048"; //nomor telepon
    String serviceDesk = "6288211130048";
    public Handler handler = new Handler();
    public Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //content vie diatur sebagai activity main
        setContentView(R.layout.activity_main);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(MainActivity.this, PanicActivity.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        //membuat objek animasi
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //inisialisasi interpolator dari ibjek
        final MyBounceInterpolator interpolator = new MyBounceInterpolator(100000, 200);
        //editText=(EditText)findViewById(R.id.editText1);
        //imagevie disetting sebagai imageVie0
        imageView = (ImageView) findViewById(R.id.imageView0);
        //handler berjalan sebagai delay
        //fungsi permulaan untuk delay
        new Handler().postDelayed(new Runnable() {
            @Override
            //akan berjalan sesudah delay selesai
            public void run() {

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {       //intent pemanggilan fungsi call
                            myAnim.setInterpolator(interpolator);
                            Intent intent = new Intent(Intent.ACTION_CALL);  //intent baru
                            intent.setData(Uri.parse("tel:" + nT));           //identifikasi nomor
                            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED)          //cek permission kalo oke langsung jalan
                            {
                                imageView.startAnimation(myAnim);
                                startActivity(intent);
                            }                    //start call
                            else {
                                requestPermissions(new String[]{CALL_PHONE}, 1);             //request permission
                            }
                        }
                    }
                });
            }
        }, 1000);


    }

    //Fungsi WhatsApp Chat, tambahkan chatWhatsApp pada layout dengan tag "onclick=chatWhatsApp"
    // TODO: 03/10/18 chat realtime masih gagal
    public void chatWhatsApp(View view) {
        try {
            String toNumber = serviceDesk;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            for (int i=0;i<3;i++) {
                if (i==0){
                    String message = "test0";
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + message));
                    startActivity(intent);
                }
                else if (i==1){
                    String message = "test1";
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + message));
                    startActivity(intent);
                }
                else if (i==2){
                    String message = "test2";
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + message));
                    startActivity(intent);
                }
                i++;}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //call versi 1
// TODO: 28/09/18 membuat fungsi kirim langsung ke whatsaap ditambah load nama dan lokasi ldap
    public void callWhatsApp(View view){
        try{
            String number = serviceDesk.replace("+","");
            //addition 1
            String mimeCall =  "vnd.android.cursor.item/vnd.com.whatsapp.voip.call";
            Intent callIntent = new Intent("android.intent.action.MAIN");
            callIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
            callIntent.putExtra("jid", number + "@s.whatsapp.net");
            //addition 2
            //callIntent.setAction(Intent.ACTION_VIEW);
            //callIntent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + number),mimeCall);
            //callIntent.setPackage("com.whatsapp");
            startActivity(callIntent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // TODO: 28/09/18 membuat fungsi gps kirim langsung ke whatsapp
    public void gps(View view){

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String realIPAddress = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
        final Toast toast = Toast.makeText(getApplicationContext(), "Your Local IP: "+realIPAddress, Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },500);

    }

    // TODO: 28/09/18 membuat fungsi sms
    public void sms(View view){
        final Toast toast = Toast.makeText(getApplicationContext(), "SMS is still in development", Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },500);
    }

    // TODO: 28/09/18 Membuat fungsi email
    public void mail(View view){
  /*      final Toast toast = Toast.makeText(getApplicationContext(), "Mail is still in development", Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },500);
*/
        Intent intent = new Intent(this, TicketActivity.class);
        startActivity(intent);
    }
    //gagal
    public void handlerFunc(Handler handler, final Toast toast){
        this.toast = toast;
        this.handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },500);
    }

    public void liveChat(View view){
        Intent intent = new Intent(this, Livechat.class);
        startActivity(intent);
    }

    public void liveChatAdmin(View view){
        Intent intent = new Intent(this, Livechatadmin.class);
        startActivity(intent);
    }
}



