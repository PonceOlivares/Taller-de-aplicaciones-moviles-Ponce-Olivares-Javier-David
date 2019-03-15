package mx.edu.ittepic.webserviceclimajson31;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    ConexionWeb conexionWeb;
    TextView clima1, clima2, climat, clima4;
    EditText city;
    Button act;
    String cadena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clima1 = findViewById(R.id.Clima1);
        clima2 = findViewById(R.id.Clima2);
        climat = findViewById(R.id.climat);
        city = findViewById(R.id.city);
        act = findViewById(R.id.button);
        //  CargarClima();

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadena =city.getText().toString();
                CargarClima();
            }
        });
    }

    public void CargarClima() {
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            URL direcciopn = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cadena+",mx&APPID=f13a7b87e50d0ffbdff7ce98e6b5384f&units=metric");
            conexionWeb.execute(direcciopn);
        } catch (MalformedURLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void procesarRespuesta(String r) {
        try {
            JSONObject object = new JSONObject(r);
            JSONArray clima = object.getJSONArray("weather");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < clima.length(); i++) {
                JSONObject objeto = clima.getJSONObject(i);

                String main = objeto.getString("main");
                String des = objeto.getString("description");
                //String coordenada = objeto.getString("coord");
                sb.append(main + " : " + des + "         ");
            }
            JSONObject clima3j = object.getJSONObject("wind");
            clima1.setText(sb + "ID: " + object.getString("id") + "\n" + "Velocidad : " + clima3j.getString("speed") +"k/h"+"\n" + " Grados: " + clima3j.getString("deg"));

            JSONObject clima2j = object.getJSONObject("main");
            clima2.setText("\n"
                    + "Temperatura: " + clima2j.getString("temp") + "C°"+"\n"
                    + "Humedad: " + clima2j.getString("pressure") +"hpa"+ "\n"
                    + "temperatura minima: " + clima2j.getString("temp_min") +"C°"+ "\n"
                    + "temperatura maxima: " + clima2j.getString("temp_max")+"C°");


        } catch (JSONException e) {
            System.out.println("" + e);
        }


    }
}
