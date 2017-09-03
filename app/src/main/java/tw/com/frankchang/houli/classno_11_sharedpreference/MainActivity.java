package tw.com.frankchang.houli.classno_11_sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1, rb2, rb3;
    CheckBox cb1, cb2;
    SeekBar seekBar;
    EditText etInput;
    Switch aSwitch;

    final String FILE_NAME = "FILE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviewer();
    }

    private void findviewer(){
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        etInput = (EditText) findViewById(R.id.editText);
        aSwitch = (Switch) findViewById(R.id.switch1);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        rb1.setChecked(sharedPreferences.getBoolean("rb1", false));
        rb2.setChecked(sharedPreferences.getBoolean("rb2", false));
        rb3.setChecked(sharedPreferences.getBoolean("rb3", false));
        cb1.setChecked(sharedPreferences.getBoolean("cb1", false));
        cb2.setChecked(sharedPreferences.getBoolean("cb2", false));
        seekBar.setProgress(sharedPreferences.getInt("seekBar", 0));
        etInput.setText(sharedPreferences.getString("etInput",""));
        aSwitch.setChecked(sharedPreferences.getBoolean("aSwitch", false));
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("rb1", rb1.isChecked());
        editor.putBoolean("rb2", rb2.isChecked());
        editor.putBoolean("rb3", rb3.isChecked());
        editor.putBoolean("cb1", cb1.isChecked());
        editor.putBoolean("cb2", cb2.isChecked());
        editor.putInt("seekBar", seekBar.getProgress());
        editor.putString("etInput", etInput.getText().toString());
        editor.putBoolean("aSwitch", aSwitch.isChecked());
        editor.commit();
    }
}

