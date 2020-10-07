package com.diegosuarez.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }


        public void emailSend(View view) {



            EditText emailText = (EditText)findViewById(R.id.editEmail);
            String email = emailText.getText().toString();

            EditText messageText = (EditText)findViewById(R.id.editMessage);
            String message = messageText.getText().toString();

            Log.e("Email", "Contactanos");
            SendEmailService emailService = new SendEmailService();
            emailService.sendEmail(message, email);
            finish();
            Toast.makeText(ContactActivity.this, "Email enviado", Toast.LENGTH_LONG).show();



    }
}