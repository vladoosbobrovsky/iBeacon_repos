package com.example.user.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.testfairy.TestFairy;

import static com.example.user.myapp.R.id;
import static com.example.user.myapp.R.string;

public class Main_Activity extends AppCompatActivity implements View.OnClickListener{

    private static final int RC_SIGN_IN = 12;
    private static final String TAG = "Text";
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    LoginButton loginButton;
    Button button01;
    Button button001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TestFairy.begin(this, "17c0ff06f0d84e5301c93cff61990312059714e3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        button01 = (Button)findViewById(id.button_sign_up1);
        button001 = (Button)findViewById(id.buttonSignIn_content);
        button01.setOnClickListener(this);
        button001.setOnClickListener(this);
           GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();
         findViewById(id.sign_in_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            Toast.makeText(Main_Activity.this, "You are Sign In !!!", Toast.LENGTH_SHORT).show();
            if (mAuth.getCurrentUser() != null)
                finish();
            toBe();


            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("Tag", "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Main_Activity.this, "You're Sign In!", Toast.LENGTH_LONG).show();
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());

                        }

                        // ...
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
        Toast.makeText(Main_Activity.this, "Doing...", Toast.LENGTH_LONG).show();
    }

    private void toBe() {
        startActivity(new Intent(this, NavigationActivity.class));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_up1:
                Intent intent = new Intent(Main_Activity.this, Activity_Sign_Up.class);
                startActivity(intent);
                break;
            case id.buttonSignIn_content:
                Intent intent001 = new Intent(Main_Activity.this, CentralMenuActivity.class);
                startActivity(intent001);
                default:
                    break;

        }
    }

}
