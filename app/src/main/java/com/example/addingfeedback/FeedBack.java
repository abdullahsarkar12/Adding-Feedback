package com.example.addingfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity implements View.OnClickListener {

    private Button sendbutton, clearbutton;
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        sendbutton = findViewById(R.id.Button1Id);
        clearbutton = findViewById(R.id.Button2Id);
        editText1 = findViewById(R.id.EditText1Id);
        editText2 = findViewById(R.id.EditText2Id);

        sendbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {

            String name = editText1.getText().toString();
            String message = editText2.getText().toString();

            if (view.getId() == R.id.Button1Id) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/mail");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdullah"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack From App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name" + name + "\n Message" + message);
                startActivity(Intent.createChooser(intent, "FeedBack With"));

            }

            if (view.getId() == R.id.Button2Id) {
                editText1.setText("");
                editText2.setText("");

            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(),"Exception: "+e,Toast.LENGTH_SHORT).show();

        }

    }
}