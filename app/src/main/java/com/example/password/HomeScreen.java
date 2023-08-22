package com.example.password;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {
    DatabaseHelper myprms;
    ImageButton save, update, view,  deletebutton, exit, infohome;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        myprms = new DatabaseHelper(getApplicationContext());

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, com.example.password.save.class);
                startActivity(intent);
            }
        });


        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, com.example.password.Update.class);
                startActivity(intent);
            }
        });



        view = findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = myprms.getData();
                if (res.getCount() == 0) {
                    showmessage("Error", "Nothing to be found.");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID: " + res.getString(0) + "\n");
                        buffer.append("E-Mail: " + res.getString(1) + "\n");
                        buffer.append("Password: " + res.getString(2) + "\n\n");
                    }
                    showmessage("Data", buffer.toString());
                }

            }

        });




        deletebutton = findViewById(R.id.deletebtn);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, com.example.password.Delete.class);
                startActivity(intent);
            }
        });



        exit=findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitConfirmationDialog();
            }
        });

        infohome=findViewById(R.id.infohome);
        infohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Infohome();
            }
        });

    }

    public void showmessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Close the current activity and go back to the previous one or exit the app
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog if "No" is clicked
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void Infohome() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("INFO");
        builder.setMessage("This is Password manager:\n" +
                "SAVE PASSWORD: You can save password.\n" +
                "UPDATE PASSWORD: You can update password.\n" +
                "VIEW PASSWORD: You can view saved password.\n" +
                "DELETE PASSWORD: You can delete saved password.\n" +
                "TO EXIT TAP ON TOP RIGHT EXIT BUTTON.");
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
