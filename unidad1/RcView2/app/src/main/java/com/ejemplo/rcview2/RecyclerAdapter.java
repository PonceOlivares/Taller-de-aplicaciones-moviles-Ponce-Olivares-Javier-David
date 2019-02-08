package com.ejemplo.rcview2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[] nombres;
    private String[] numeroControl;
    private Context contexto;


    public RecyclerAdapter(String[] nombres, String[] numeroControl, Context contexto) {
        this.nombres = nombres;
        this.numeroControl = numeroControl;
        this.contexto = contexto;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.campo_nombre.setText(nombres[position]);
        holder.campo_numeroControl.setText(numeroControl[position]);
        holder.actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(contexto);
                alerta.setTitle("ACTUALIZAZR").setMessage("estas seguro que deseas ACTUALIZAR a el usuario: " + nombres[position])
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(contexto, "ACTUALIZASTE A: " + nombres[position], Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();

            }
        });


        holder.borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(contexto);
                alerta.setTitle("BORRANDO A...").setMessage("estas seguro que deseas BORRAR a el usuario: " + nombres[position])
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(contexto, "ELIMINASTE A: " + nombres[position], Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre;
        TextView campo_numeroControl;
        ImageView actualizar, borrar;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            campo_nombre = itemView.findViewById(R.id.person_name);
            campo_numeroControl = itemView.findViewById(R.id.numeroControl);

            actualizar = itemView.findViewById(R.id.person_photo);
            borrar = itemView.findViewById(R.id.borrar);


        }
    }

}
