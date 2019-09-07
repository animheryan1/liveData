package com.example.livedatatask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {
    private EditText wordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        wordText = findViewById(R.id.edit_word);
    }

    public void saveWord(View view) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(wordText.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String word = wordText.getText().toString();
            replyIntent.putExtra("Reply", word);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    }
}
