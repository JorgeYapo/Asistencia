package jlyv.upeu.edu.pe.googlemaps.drawnavrecyclerview;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jlyv.upeu.edu.pe.googlemaps.HomeActivity;
import jlyv.upeu.edu.pe.googlemaps.MainActivity;
import jlyv.upeu.edu.pe.googlemaps.servis.UsuarioServices;
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;
import jlyv.upeu.edu.pe.googlemaps.to.UsuarioTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rest {

    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    UsuarioServices usuarioServis;
    private String ip_url = "http://192.168.1.33:8080/";
    ArrayList<EventoTO> eventosdevueltos ;


    public Rest(){
        retrofit=new Retrofit.Builder()
                .baseUrl(ip_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
    }

    private void listarEventox(){
        Call<List<EventoTO>> listarEventoTodos=this.usuarioServis.listarEvento();
        listarEventoTodos.enqueue(new Callback<List<EventoTO>>() {
            @Override
            public void onResponse(Call<List<EventoTO>> call, Response<List<EventoTO>> response) {
                for (int i=0 ; i < response.body().size(); i++){
                    eventosdevueltos.add(response.body().get(i));
                }
//                return eventosdevueltos;
                Log.e(TAG,"Llego el rest.......!"+response.body().size());
            }
            @Override
            public void onFailure(Call<List<EventoTO>> call, Throwable t) {
                Log.e(TAG,"Error al recuperar el Servicio Rest de Usuario!");
            }
        });


//    UsuarioTO user=new UsuarioTO();
//        user.setUsuario(usuario);
//        user.setClave(passwprd);
//    Call<UsuarioTO> call=usuarioServis.login(user);
//        call.enqueue(new Callback<UsuarioTO>() {
//        @Override
//        public void onResponse(Call<UsuarioTO> call, Response<UsuarioTO> response) {
//            Toast.makeText(MainActivity.this, "Bienvenido al sistema ", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent().setClass(MainActivity.this,HomeActivity.class));
//        }
//
//        @Override
//        public void onFailure(Call<UsuarioTO> call, Throwable t) {
//            Toast.makeText(getApplicationContext(),"El usuario o la contraseña con incorrectos", Toast.LENGTH_SHORT).show();
//            Log.e(TAG, t.toString());
//        }
//    });

    }

}
