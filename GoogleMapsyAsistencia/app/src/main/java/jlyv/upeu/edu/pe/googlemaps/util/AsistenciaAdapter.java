package jlyv.upeu.edu.pe.googlemaps.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jlyv.upeu.edu.pe.googlemaps.R;
import jlyv.upeu.edu.pe.googlemaps.to.AsistenciaTO;
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.AsistenciaViewHolder> {
    private List<AsistenciaTO> asistencia;

    public static class AsistenciaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtLugar;

        private AsistenciaTO asistecia;


        public AsistenciaViewHolder(View itemView) {
            super(itemView);
            this.txtNombre=(TextView) itemView.findViewById(R.id.txtNombre);
            this.txtLugar=(TextView) itemView.findViewById(R.id.txtLugar);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Context context=v.getContext();
                    Toast.makeText(context,asistecia.getCompanhia(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setEvento(AsistenciaTO asistecia){
            this.asistecia=asistecia;
            this.txtNombre.setText(asistecia.getOfline());
            this.txtLugar.setText(asistecia.getCompanhia());
        }

    }






    public AsistenciaAdapter(List<AsistenciaTO> asistencia){
        this.asistencia=asistencia;
    }

    @Override
    public AsistenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.lista, parent, false);
        AsistenciaViewHolder viewHolder=new AsistenciaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AsistenciaViewHolder holder, int position) {
        AsistenciaTO asistenciax=asistencia.get(position);

        holder.setEvento(asistenciax);
    }

    @Override
    public int getItemCount() {
        return asistencia.size();
    }



}
