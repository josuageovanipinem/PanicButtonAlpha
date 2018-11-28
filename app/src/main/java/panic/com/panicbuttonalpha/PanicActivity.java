//todo tiap variable yang ada harus di pass ke jsonackage panic.com.panicbuttonalpha;
package panic.com.panicbuttonalpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import panic.com.panicbuttonalpha.R;

public class PanicActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private Spinner spinner1;
    private Spinner spinner2;
    TextView namaIsian;
    TextView nipIsian;
    TextView emailIsian;
    TextView noTelpIsian;
    public static final String mypreference = "mypref";
    public static final String Nama = "nama";
    public static final String NIP = "nip";
    public static final String Telp = "telp";
    public static final String Email = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);
        namaIsian = (TextView) findViewById(R.id.namaIsian);
        nipIsian = (TextView) findViewById(R.id.nipIsian);
        noTelpIsian = (TextView) findViewById(R.id.noTelpIsian);
        emailIsian = (TextView) findViewById(R.id.emailIsian);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener2());
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Nama)){
            namaIsian.setText(sharedPreferences.getString(Nama, ""));
            }
        if (sharedPreferences.contains(Email)){
            emailIsian.setText(sharedPreferences.getString(Email,""));
        }
        if (sharedPreferences.contains(NIP)){
            nipIsian.setText(sharedPreferences.getString(NIP,""));
        }
        if (sharedPreferences.contains(Telp)){
            noTelpIsian.setText(sharedPreferences.getString(Telp,""));
        }
        }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }

    public class CustomOnItemSelectedListener2 implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner2.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner2.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }
//updated simpan data
    public void firstLogin(View view){
        String n = namaIsian.getText().toString();
        String e = emailIsian.getText().toString();
        String t = noTelpIsian.getText().toString();
        String ni = nipIsian.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Nama,n);
        editor.putString(NIP,ni);
        editor.putString(Email,e);
        editor.putString(Telp,t);
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}