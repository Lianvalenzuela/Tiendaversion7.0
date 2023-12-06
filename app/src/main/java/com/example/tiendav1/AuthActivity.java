package com.example.tiendav1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.nfc.Tag;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    private Button signInButton;
    private Button mqqt_btn;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private RatingBar rbr1;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleAuth;
    private TextView registro;

    String titulo = "Autenticacion";
    private FirebaseAnalytics mFirebaseanalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.mi_titulo);

        //firebase analytics
        mFirebaseanalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("message", "Integracion de firebase completa");
        mFirebaseanalytics.logEvent("InitScreen", bundle);
        setContentView(R.layout.activity_auth);

        //firebase auth y Autentificacion de Google
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string))


        //Inicializacion editText y TextView
        emailEditText = (TextInputEditText) findViewById(R.id.email);
        passwordEditText = (TextInputEditText) findViewById(R.id.password);
        registro = (TextView) findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        mqqt_btn = findViewById(R.id.mqttbtn);
        mqqt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, mqttActivity.class);
                startActivity(intent);
            }
        });


        //inicializacion de la barra de calificacion
        rbr1 = (RatingBar) findViewById(R.id.rbr1);

        //Mostrar la siguiente actividad
        signInButton=findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(emailEditText.getText());
                password = String.valueOf(passwordEditText.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(AuthActivity.this, "Ingresar email: ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(AuthActivity.this, "Ingresar contraseña: ", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(AuthActivity.this, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show();
                                    Intent intentS = new Intent(AuthActivity.this, Comp.class);
                                    startActivity(intentS);
                                }else{
                                    Toast.makeText(AuthActivity.this, "Inicio de sesion fallido", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void calificacion(View v) {
        Toast.makeText(AuthActivity.this, "Has seleccionado un rating de: " + rbr1.getRating() + " estrellas!", Toast.LENGTH_SHORT).show();
    }

}