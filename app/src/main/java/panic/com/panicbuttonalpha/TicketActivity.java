package panic.com.panicbuttonalpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        if (inputNama.getText().toString().length()==0){
            inputNama.setError("Nama diperlukan");
        }
        String nama = inputNama.getText().toString();
        hasilNama.setText(nama);
        String nip = inputNip.getText().toString();
        hasilNip.setText(nip);
        String umur = inputTelp.getText().toString();
        hasilTelp.setText(umur);
        String email = inputEmail.getText().toString();
        hasilEmail.setText(email);
        String institusi = inputUnit.getText().toString();
        hasilUnit.setText(institusi);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
