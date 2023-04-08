package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameField, passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Find views by their ID and set click listener for login button
        usernameField = findViewById(R.id.username_field);
        passwordField = findViewById(R.id.password_field);
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();

            // Authenticate user (example only, replace with your own logic)
            if (username.equals("admin") && password.equals("password")) {
                // Login successful, navigate to main activity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Login failed, display error message
                passwordField.setText("");
                passwordField.setError("Invalid username or password");
            }
        }
    }
}
