package jlyv.upeu.edu.pe.googlemaps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jlyv.upeu.edu.pe.googlemaps.servis.UsuarioServices;
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;
import jlyv.upeu.edu.pe.googlemaps.to.UsuarioTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Context contex;
    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    UsuarioServices usuarioServis;

    @BindView(R.id.txtUsuario)
    TextView txtUsuario;

    @BindView(R.id.txtPassword)
    TextView txtPassword;

//    //prubeas
//    private TextView txtDni, txtUseres, txtNombres, txtApellidos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        contex=getApplication();

    }

    @OnClick(R.id.btnLogin)
    public void irPaginaPrincipal(){
        validar(txtUsuario.getText().toString(),txtPassword.getText().toString());
    }

    public void validar(String usuario, String passwprd){
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
                startActivity(new Intent().setClass(MainActivity.this,HomeActivity.class));
            }

            @Override
            public void onFailure(Call<UsuarioTO> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"El usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });

    }
}
