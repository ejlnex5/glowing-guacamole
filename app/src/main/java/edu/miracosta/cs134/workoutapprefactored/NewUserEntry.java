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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewUserEntry extends AppCompatActivity implements View.OnClickListener {


    private EditText editUsername, editEmail, editPassword;
    private ProgressDialog progressDialog;
    private Button buttonUserEntry;

    public NewUserEntry() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_entry);

        editEmail = (EditText) findViewById(R.id.newemail);
        editUsername = (EditText) findViewById(R.id.newusername);
        editPassword = (EditText) findViewById(R.id.newpassword);

        buttonUserEntry = (Button) findViewById(R.id.buttonUserEntry);

        progressDialog = (new ProgressDialog(this));

        buttonUserEntry.setOnClickListener(this);
    }

    private void createUser(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String username = editUsername.getText().toString().trim();

        progressDialog.setMessage("Creating user...");
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
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void onClick(View view) {
        if (view == buttonUserEntry) {
            createUser();
            Intent toMenu = new Intent(this, WorkoutDiary.class);
            startActivity(toMenu);
        }
    }



}
