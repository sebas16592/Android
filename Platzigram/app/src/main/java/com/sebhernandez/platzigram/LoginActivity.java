package com.sebhernandez.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.sebhernandez.platzigram.view.ContainerActivity;
import com.sebhernandez.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void goLogin(View view){
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        String user=username.getText().toString();
        String pass=password.getText().toString();
        //if (user.equals("Sebas") && pass.equals("123")){
            Intent intent = new Intent(this, ContainerActivity.class);
            startActivity(intent);
        /*}else{
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Debe ingresar el usuario correcto", Toast.LENGTH_SHORT);

            toast1.show();
        }*/
    }

    public void goWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.sebhernandez.com"));

        startActivity(intent);
    }
}
