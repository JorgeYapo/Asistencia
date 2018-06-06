package com.example.yapo.asistesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yapo.asistesia.servis.UsuarioServices;
import com.example.yapo.asistesia.to.UsuarioTO;

import java.util.List;

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
        password = (EditText)findViewById(R.id.txtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);


        initView();
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.33:8080/") // Colocar la direccion ip del servicio rest
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
        listarUsuariox(usuarioServis);
    }

    private void initView(){
        this.txtDni=(TextView)findViewById(R.id.txtDni);
        this.txtUsuario=(TextView)findViewById(R.id.txtUsuario);
        this.txtNombres=(TextView)findViewById(R.id.txtNombre);
        this.txtApellidos=(TextView)findViewById(R.id.txtApellidos);
    }

    public void onRegistrarUser(View view){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.33:8080/") // Colocar la direccion ip del servicio rest
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
        UsuarioTO user=new UsuarioTO();
        user.setIdUsuario(new Integer(8));
        user.setUsuario("roberto");
        user.setNombres("Juan");
        user.setApellidos("Ramos Quispe");
        user.setClave("123456");
        user.setDnicodigo("54872418");
        user.setEmail("moisesmp@gmail.com");
        user.setEstadousuario("1");
        crearUsuario(usuarioServis, user);

    }

    private void crearUsuario(UsuarioServices userService, UsuarioTO user){
        Call<UsuarioTO> call=userService.guardarUsuario(user);
        call.enqueue(new Callback<UsuarioTO>() {
            @Override
            public void onResponse(Call<UsuarioTO> call, Response<UsuarioTO> response) {
                // mostrarUsuarios(response.body());
            }

            @Override
            public void onFailure(Call<UsuarioTO> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"No se puede crear Usuario", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });
    }

    private void listarUsuariox(UsuarioServices usuarioServis){
        Call<List<UsuarioTO>> listarUsuarioTodos=usuarioServis.listarUsuario();
        listarUsuarioTodos.enqueue(new Callback<List<UsuarioTO>>() {
            @Override
            public void onResponse(Call<List<UsuarioTO>> call, Response<List<UsuarioTO>> response) {
                mostrarUsuarios(response.body().get(0));
                Log.e(TAG,"Llego.......!"+response.body().size());
            }

            @Override
            public void onFailure(Call<List<UsuarioTO>> call, Throwable t) {
                Log.e(TAG,"Error al recuperar el Servicio Rest de Usuario!");
            }
        });
    }

    private void mostrarUsuarios(UsuarioTO usuario){
        txtDni.setText(usuario.getDnicodigo().toString());
        txtUsuario.setText(usuario.getUsuario().toString());
        txtNombres.setText(usuario.getNombres().toString());
        txtApellidos.setText(usuario.getApellidos().toString());
    }

}
