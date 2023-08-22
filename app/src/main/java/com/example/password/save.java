package com.example.password;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.manager.ImageAssetManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class save extends AppCompatActivity {
    DatabaseHelper myprms;
    TextInputEditText id, email, password;
    Button save;
    ImageButton infosave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        myprms = new DatabaseHelper(getApplicationContext());

        id=findViewById(R.id.IDbox);
        email=findViewById(R.id.emailbox);
        password=findViewById(R.id.passwordbox);

        save=findViewById(R.id.savep);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert = myprms.insert(
                        id.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString());
                        if (isInsert == true)
                            Toast.makeText(save.this, "Data Inserted Succesfully", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(save.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        infosave=findViewById(R.id.infosave);
        infosave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Infohome();
            }
        });

    }

    private void Infohome() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("INFO");
        builder.setMessage("-------------Password manager-------------\n" +
                "To save password use unique ID for each."
                );
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can perform any actions here if needed
                dialog.dismiss(); // Dismiss the dialog when "OK" is clicked
            }
        });

        builder.show();
    }
}