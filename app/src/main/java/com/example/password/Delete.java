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

public class Delete extends AppCompatActivity {
    DatabaseHelper myprms;

    TextInputLayout ID;
    TextInputEditText del;
    Button delete;

    ImageButton infodelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        myprms = new DatabaseHelper(getApplicationContext());

        ID=findViewById(R.id.layoutid);
        del = findViewById(R.id.iddelete);
        delete=findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myprms.Delete(del.getText().toString());

                if(inserted == true)
                {
                    Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Delete.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        infodelete=findViewById(R.id.infodelete);
        infodelete.setOnClickListener(new View.OnClickListener() {
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
                "To Delete any detail please use correct ID."
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