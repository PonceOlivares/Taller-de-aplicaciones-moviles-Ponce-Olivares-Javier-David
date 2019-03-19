package mx.edu.ittepic.a32consumodeserviciosweb;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    ConexionWeb conexionWeb;
    LinearLayout cargar;
    RecyclerView lista;
    private RecyclerView.LayoutManager mLayoutManager;
    AdaptadorTerremoto adapter;
    ArrayList<Terremotos> terremotosArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargar=findViewById(R.id.linearCargar);
        lista=findViewById(R.id.lista); //terremotos
        lista.setLayoutManager(new LinearLayoutManager(this));
        terremotosArrayList=new ArrayList<>();
        cargarTerremotos();
    }

    public void cargarTerremotos() {
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            // https://es.earthquake-report.com/2013/06/29/earthquake-report-com-json-and-rss-feeds/
            URL direcciopn = new URL("https://es.earthquake-report.com/feeds/recent-eq?json");
            conexionWeb.execute(direcciopn);
        } catch (MalformedURLException e) {
            Toasty.error(MainActivity.this, "Error Conexion: "+e.getMessage(), Toast.LENGTH_LONG, true).show();
            cargar.setVisibility(View.VISIBLE);
            lista.setVisibility(View.GONE);
        }
    }
    @Override
    public void procesarRespuesta(String r) {
        try {
            JSONArray terremoto= new JSONArray(r);
            for (int i = 0; i < terremoto.length(); i++) {
                JSONObject terremotointerno = terremoto.getJSONObject(i);
                terremotosArrayList.add(new Terremotos(
                        "Titulo: "+terremotointerno.getString("title"),
                        "Magnitud: "+terremotointerno.getString("magnitude"),
                        "Localización: "+terremotointerno.getString("location"),
                        "Profundidad: "+terremotointerno.getString("depth")+" km",
                        "Latitud: "+terremotointerno.getString("latitude"),
                        "Longitud: "+terremotointerno.getString("longitude"),
                        "Fecha: "+terremotointerno.getString("date_time")));
            }

        }catch (JSONException e){
            System.out.println(""+e);
            Toasty.error(MainActivity.this, "Error JSON: "+e, Toast.LENGTH_LONG, true).show();
            cargar.setVisibility(View.VISIBLE);
            lista.setVisibility(View.GONE);
        }

        adapter=new AdaptadorTerremoto(terremotosArrayList,getApplicationContext());
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lista.setAdapter(adapter);
        cargar.setVisibility(View.GONE);
        lista.setVisibility(View.VISIBLE);
    }
}
