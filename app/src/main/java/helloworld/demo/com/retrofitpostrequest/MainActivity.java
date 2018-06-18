package helloworld.demo.com.retrofitpostrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText name, email, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edt1);
        email = (EditText) findViewById(R.id.edt2);
        password = (EditText) findViewById(R.id.edt3);
        register = (Button) findViewById(R.id.btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendNetworkRequest();
            }
        });
    }

    private void sendNetworkRequest() {

        String s1 = name.getText().toString().trim();
        String s2 = email.getText().toString().trim();
        String s3 = password.getText().toString().trim();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://www.godigitell.in/dev/hrportal/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        UserClient client = retrofit.create(UserClient.class);


        Call<User> call = client.createAccount(s1,s2,s3);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                Log.d("RESPONSE",response.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Not Success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
