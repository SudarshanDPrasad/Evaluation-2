package com.example.datatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String FILE_NAME = "myFile" ;
    private EditText metEmailid;
    private EditText metPassword;
    private CheckBox mcheckbox;
    private TextView btnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);

        String emailid = sharedPreferences.getString("Emailid","");
        String Password = sharedPreferences.getString("Password","");

        metEmailid.setText(emailid);
        metPassword.setText(Password);


        if(mcheckbox.isChecked()){
            Intent intent = new Intent(MainActivity.this,HomeScreenActivity.class);
            startActivity(intent);
        }else if(!mcheckbox.isChecked()) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isEmailVlaid() && isPassword()) {
                        Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    }

                    String Emailid = metEmailid.getText().toString();
                    String Password = metPassword.getText().toString();

                    if (mcheckbox.isChecked()) {
                        StoreData(Emailid, Password);
                    }
                    Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void StoreData(String Emailid, String Password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("Emailid",Emailid);
        editor.putString("Password",Password);
        editor.apply();

    }

    private void initviews() {
        mcheckbox = findViewById(R.id.etcheckbox);
        metEmailid = findViewById(R.id.etEmailid);
        metPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

    }
    private boolean isEmailVlaid() {
        if (metEmailid.getText().toString().length() >= 1 &&
                metEmailid.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            metEmailid.setError("InvalidEmail");
            return false;
        }
    }

    private boolean isPassword(){
        if(metPassword.getText().toString().length()>6){
            return true;
        }else {
            Toast.makeText(MainActivity.this,"The Password is too short ",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}