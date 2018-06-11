package jlyv.upeu.edu.pe.googlemaps.drawnavrecyclerview;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import jlyv.upeu.edu.pe.googlemaps.R;
import jlyv.upeu.edu.pe.googlemaps.servis.UsuarioServices;
import jlyv.upeu.edu.pe.googlemaps.to.AsistenciaTO;
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;
import jlyv.upeu.edu.pe.googlemaps.util.AsistenciaAdapter;
import jlyv.upeu.edu.pe.googlemaps.util.EventoAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepAs extends Fragment {


    List<AsistenciaTO> asistencia;
    RecyclerView recyclerView;
    RecyclerView.Adapter<AsistenciaAdapter.AsistenciaViewHolder> adapter;
    RecyclerView.LayoutManager layoutManager;
    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    UsuarioServices usuarioServis;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myFragmentView= inflater.inflate(R.layout.activity_rep_as, container, false);

        this.recyclerView=(RecyclerView)myFragmentView.findViewById(R.id.recyclerView);
        this.layoutManager = new LinearLayoutManager(this.getContext());

        // Rest
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.33:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
        Call<List<AsistenciaTO>> listarAsistenciaTodos=usuarioServis.listarAsistencia();
        listarAsistenciaTodos.enqueue(new Callback<List<AsistenciaTO>>() {
            @Override
            public void onResponse(Call<List<AsistenciaTO>> call, Response<List<AsistenciaTO>> response) {

                asistencia = response.body();
                adapter=new AsistenciaAdapter(asistencia);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                Toast.makeText(getContext(), "Llego la sistencia.......!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<AsistenciaTO>> call, Throwable t) {
                Toast.makeText(getContext(), "Error al recuperar rest asistencia", Toast.LENGTH_SHORT).show();
            }
        });


        return myFragmentView;
    }



}
