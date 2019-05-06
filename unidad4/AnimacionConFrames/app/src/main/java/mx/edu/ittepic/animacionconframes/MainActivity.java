package mx.edu.ittepic.animacionconframes;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button buttonRun, buttonStop;
    AnimationDrawable animacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonRun = findViewById(R.id.buttonRun);
        buttonStop = findViewById(R.id.buttonStop);
        //running = false;

        if (imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.slow);
        imageView.setVisibility(View.INVISIBLE);

        animacion = (AnimationDrawable) imageView.getBackground();

        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                if (animacion.isRunning())
                    animacion.stop();
                animacion.start();

            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion.stop();
            }
        });
    }

}
