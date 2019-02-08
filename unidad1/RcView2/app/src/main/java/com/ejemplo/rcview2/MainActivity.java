package com.ejemplo.rcview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private int update, delete;


    String [] nombres={"ARANDA PATRON NOMAR JAZIEL",
            "CARDENAS RAMOS FRANCISCO EMANUEL",
            "CASTILLO CORRALES VICTOR EMMANUEL",
            "CERVANTES JIMÉNEZ JOSÉ MIGUEL",
            "CORDERO RIVERA SELVA YAZMIN",
            "CORDERO VILLA OSCAR ALBERTO",
            "ESPINOSA ABANDO DENISSE YANETH",
            "FIGUEROA CUETO JUAN RAMON",
            "GALLEGOS GODINEZ FRANCISCO JAVIER",
            "GIL LLANOS JUAN PEDRO",
            "GONZALEZ ARELLANO ERNESTO",
            "GUTIERREZ ESPARZA BRAYAN JESUS",
            "GUTIÉRREZ ROJAS BRYAN",
            "LOPEZ ALVARADO MISSAEL",
            "MARTINEZ BAÑUELOS ERIKA LIZBETH",
            "MENDEZ SANTANA KEVIN ALEJANDRO",
            "MONROY SALCEDO JOSE DE JESUS",
            "PADILLA SIMÓN BRIAN EFRÉN",
            "PARRA DOMINGUEZ DYLAN SALVADOR",
            "PEREZ ARAIZA FLOR MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GODINEZ CARLA GUADALUPE",
            "REYES GUERRERO GUILLERMO GUADALUPE",
            "RICO ESPARZA HENRY",
            "RIVERA RAMIREZ DAVID",
            "SANCHEZ CARRILLO BETSY DEL CARMEN",
            "SILVA CAMACHO EDUARDO LUIS",
            "TORRES CUETO JESUS MANUEL",
            "VALDEZ LOPEZ HOLLIVER EDUARDO",
            "VALENZUELA MIRAMONTES JOSE PABLO",
            "ZAMORANO ALCALÁ GUILLERMO"};

    String[]numeroControl={
            "15400001",
            "15400002",
            "15400003",
            "15400004",
            "15400005",
            "15400006",
            "15400007",
            "15400008",
            "15400009",
            "15400010",
            "15400011",
            "15400012",
            "15400013",
            "15400014",
            "15400015",
            "15400016",
            "15400017",
            "15400018",
            "15400019",
            "15400020",
            "15400021",
            "15400022",
            "15400023",
            "15400024",
            "15400025",
            "15400026",
            "15400027",
            "15400028",
            "15400029",
            "15400030",
            "15400031",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);


        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(nombres, numeroControl, this);
        //adapter2 = new RecyclerAdapter(numeroControl);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);
    //    recyclerView.setAdapter(adapter2);

    }
}
