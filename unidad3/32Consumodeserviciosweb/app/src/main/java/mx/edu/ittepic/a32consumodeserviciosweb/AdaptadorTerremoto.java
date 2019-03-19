package mx.edu.ittepic.a32consumodeserviciosweb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorTerremoto extends RecyclerView.Adapter<AdaptadorTerremoto.ViewHolderAlumnos> implements View.OnClickListener {
    ArrayList<Terremotos> listaterremotos;
    private View.OnClickListener listener;
    Context context;
    public AdaptadorTerremoto(ArrayList<Terremotos> listaAlumnos, Context context) {
        this.listaterremotos = listaAlumnos;
        this.context=context;
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=R.layout.vista_terremoto;
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);
        return new ViewHolderAlumnos(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderAlumnos holder, int position) {

        holder.titulo.setText(listaterremotos.get(position).getTitulo());
        holder.lugar.setText(listaterremotos.get(position).getTipo());
        holder.magnitud.setText(listaterremotos.get(position).getMagnitud());
        holder.profundidad.setText(listaterremotos.get(position).getProfundidad());
        holder.lat.setText(listaterremotos.get(position).getLatitud());
        holder.lon.setText(listaterremotos.get(position).getLongitud());
        holder.fecha.setText(listaterremotos.get(position).getFecha());
    }
    @Override
    public int getItemCount() {
        return listaterremotos.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }
    public class ViewHolderAlumnos extends RecyclerView.ViewHolder {
        TextView titulo,lugar,magnitud,profundidad,lat,lon,fecha;
        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            titulo= (TextView) itemView.findViewById(R.id.titulo);
            lugar= (TextView) itemView.findViewById(R.id.lugar);
            magnitud= (TextView) itemView.findViewById(R.id.magintud);
            profundidad= (TextView) itemView.findViewById(R.id.profundidad);
            lat= (TextView) itemView.findViewById(R.id.lat);
            lon= (TextView) itemView.findViewById(R.id.lon);
            fecha= (TextView) itemView.findViewById(R.id.fecha);
        }
    }
}
