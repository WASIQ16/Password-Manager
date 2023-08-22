package com.example.password;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Update extends AppCompatActivity {
    DatabaseHelper myprms;
    TextInputEditText idu, emailu, passwordu;
    Button update;
    ImageButton infoupdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myprms = new DatabaseHelper(getApplicationContext());

        idu=findViewById(R.id.ID);
        emailu=findViewById(R.id.emailu);
        passwordu=findViewById(R.id.passwordu);

        update=findViewById(R.id.updatepass);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myprms.Update(
                        idu.getText().toString(),
                        emailu.getText().toString(),
                        passwordu.getText().toString());

                if(inserted == true)
                {
                    Toast.makeText(Update.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Update.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        infoupdate=findViewById(R.id.infoupdate);
        infoupdate.setOnClickListener(new View.OnClickListener() {
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
                "To update any detail please use correct ID."
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