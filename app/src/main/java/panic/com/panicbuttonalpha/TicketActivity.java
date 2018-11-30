package panic.com.panicbuttonalpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TicketActivity extends AppCompatActivity {

    @BindView(R.id.input_nama)
    EditText inputNama;
    @BindView(R.id.input_nip)
    EditText inputNip;
    @BindView(R.id.input_telp)
    EditText inputTelp;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_unit)
    EditText inputUnit;

    @BindView(R.id.simpan_button)
    Button simpan_button;

    @BindView(R.id.hasil_nama)
    TextView hasilNama;
    @BindView(R.id.hasil_nip)
    TextView hasilNip;
    @BindView(R.id.hasil_telp)
    TextView hasilTelp;
    @BindView(R.id.hasil_email)
    TextView hasilEmail;
    @BindView(R.id.hasil_unit)
    TextView hasilUnit;

    SharedPreferences sharedPreferences;
    public static final String mypreference = "mypref";
    public static final String Nama = "nama";
    public static final String NIP = "nip";
    public static final String Telp = "telp";
    public static final String Email = "email";
    public static final String Unit = "unit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ButterKnife.bind(this);
        }

    @OnClick(R.id.simpan_button)
    public void btnClicked() {
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Nama)){
            inputNama.setText(sharedPreferences.getString(Nama, ""));
        }
        if (sharedPreferences.contains(Email)){
            inputEmail.setText(sharedPreferences.getString(Email,""));
        }
        if (sharedPreferences.contains(NIP)){
            inputNip.setText(sharedPreferences.getString(NIP,""));
        }
        if (sharedPreferences.contains(Telp)){
            inputTelp.setText(sharedPreferences.getString(Telp,""));
        }
        if (sharedPreferences.contains(Unit)){
            inputUnit.setText(sharedPreferences.getString(Unit,""));
        }
/*        String nama = inputNama.getText().toString();
        hasilNama.setText(nama);
        String nip = inputNip.getText().toString();
        hasilNip.setText(nip);
        String umur = inputTelp.getText().toString();
        hasilTelp.setText(umur);
        String email = inputEmail.getText().toString();
        hasilEmail.setText(email);
        String institusi = inputUnit.getText().toString();
        hasilUnit.setText(institusi);*/
    }

    public void firstLogin(View view){
        String n = hasilNama.getText().toString();
        String e = hasilEmail.getText().toString();
        String t = hasilTelp.getText().toString();
        String ni = hasilNip.getText().toString();
        String u = hasilUnit.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Nama,n);
        editor.putString(NIP,ni);
        editor.putString(Email,e);
        editor.putString(Telp,t);
        editor.putString(Unit,u);
        editor.apply();

        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }




}
