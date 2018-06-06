package com.example.yapo.asistensia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yapo.asistensia.mapas.Geolocalizacion;
import com.example.yapo.asistensia.servis.UsuarioServices;
import com.example.yapo.asistensia.to.UsuarioTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private Button btnlogin;

    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    UsuarioServices usuarioServis;
    private TextView txtDni, txtUsuario, txtNombres, txtApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById(R.id.txtuser);
        password = (EditText)findViewById(R.id.txtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                String user = usuario.getText().toString();
                String pas = password.getText().toString();
                Toast.makeText(MainActivity.this, "Hola "+user+" +++ "+ pas, Toast.LENGTH_SHORT).show();
                validar(v,user,pas);

            }
        });
    }


    public void validar(View view, String usuario, String passwprd){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.33:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
        UsuarioTO user=new UsuarioTO();
        user.setUsuario(usuario);
        user.setClave(passwprd);
        Call<UsuarioTO> call=usuarioServis.login(user);
        call.enqueue(new Callback<UsuarioTO>() {
            @Override
            public void onResponse(Call<UsuarioTO> call, Response<UsuarioTO> response) {
                Toast.makeText(MainActivity.this, "Bienvenido al sistema ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent().setClass(MainActivity.this,Geolocalizacion.class));
            }

            @Override
            public void onFailure(Call<UsuarioTO> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"El usuario o la contraseña con incorrectos", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });

    }



}
