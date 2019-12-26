package com.madantiwari.taskmanagerapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText etfirstName,etlastName,etusernameSign,etPasswordSign,etConfirPW;
    ImageView imageView;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etfirstName = findViewById(R.id.etFirstName);
        etusernameSign = findViewById(R.id.etSignUserName);
        etPasswordSign = findViewById(R.id.etPasswordSign);
        etlastName = findViewById(R.id.etLastName);
        etConfirPW = findViewById(R.id.etConfirmPW);
        imageView = findViewById(R.id.imageView);
        btnSignup = findViewById(R.id.btnSignUp);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });
    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*"); //browse only image
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imageView.setImageURI(uri);

    }
}
