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
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;
//import pe.edu.upeu.drawnavrecyclerview.R;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {
    private List<EventoTO> evento;

    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtLugar;

        private EventoTO evento;


        public EventoViewHolder(View itemView) {
            super(itemView);
            this.txtNombre=(TextView) itemView.findViewById(R.id.txtNombre);
            this.txtLugar=(TextView) itemView.findViewById(R.id.txtLugar);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Context context=v.getContext();
                    Toast.makeText(context,evento.getNombreevento(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setEvento(EventoTO evento){
            this.evento=evento;
            this.txtNombre.setText(evento.getNombreevento());
            this.txtLugar.setText(evento.getLugarevento());
        }

    }






    public EventoAdapter(List<EventoTO> eventos){
        this.evento=eventos;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.lista, parent, false);
        EventoViewHolder viewHolder=new EventoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {
        EventoTO eventox=evento.get(position);

        holder.setEvento(eventox);
    }

    @Override
    public int getItemCount() {
        return evento.size();
    }



}
