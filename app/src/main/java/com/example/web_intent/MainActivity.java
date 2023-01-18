package com.example.web_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.submit);

        EditText weburl = findViewById(R.id.weburl);

        Button email = findViewById(R.id.email);


        submit.setOnClickListener(View ->{
           String weburlto = weburl.getText().toString();
            searchWeb(weburlto);
        });

        //String[] email1 = new String[] {"yashc1999@gmail.com","suresh@gmail.com"};
        email.setOnClickListener(View ->{
            composeEmail("Test");
        });
        }
    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);

            startActivity(intent);

    }


    public void composeEmail(String subject) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        //intent.setData(Uri.parse("mailto:"));
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yashc1999@gmail.com","sureshchaudharypgt2017@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
       // intent.putExtra(Intent.EXTRA_STREAM, attachment);
            startActivity(intent);

    }
}