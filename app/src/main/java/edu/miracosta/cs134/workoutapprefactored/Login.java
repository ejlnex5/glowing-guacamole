package edu.miracosta.cs134.workoutapprefactored;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.internal.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.common.internal.Constants.*;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText editUsername, editEmail, editPassword;
    private Button buttonSignIn;
    private ProgressDialog progressDialog;
    private Button buttonUserEntry;

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText) findViewById(R.id.email);
//        editUsername = (EditText) findViewById(R.id.username);
        editPassword = (EditText) findViewById(R.id.password);

        buttonSignIn = (Button) findViewById(R.id.SignIn);

        progressDialog = (new ProgressDialog(this));

        buttonSignIn.setOnClickListener(this);
    }

    private void signInUser(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
//        String username = editUsername.getText().toString().trim();

        progressDialog.setMessage("Signing in...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                edu.miracosta.cs134.workoutapprefactored.Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    //params.put("username", username);
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void onClick(View view){
        if (view == buttonSignIn) {
            signInUser() ;
        }
        else if( view == buttonUserEntry) {
            navigateToNewUserEntry(view);
        }
    }

/*
    public void navigateToDiary(View view) {
        Intent navi = new Intent(this, WorkoutDiary.class);
        startActivity(navi);
    }

*/
    public void navigateToNewUserEntry(View view) {
        Intent navi = new Intent(this,NewUserEntry.class);
        startActivity(navi);
    }

}
