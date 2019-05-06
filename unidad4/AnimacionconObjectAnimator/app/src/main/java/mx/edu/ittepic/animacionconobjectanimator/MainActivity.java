package mx.edu.ittepic.animacionconobjectanimator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout playGround;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playGround = findViewById(R.id.playground);
        image = findViewById(R.id.image);
    }

    public void bounce(View v){
        int screenHeight = playGround.getHeight();
        int targetY = 0;
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                image, "y", screenHeight, targetY)
                .setDuration(2500);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void acelerate (View v){
        int screenHeight = playGround.getHeight();
        int targetY = screenHeight - image.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                image, "y", 0, targetY)
                .setDuration(2000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }

    public void decelerate(View v){
        int screenHeight = playGround.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                image, "y", screenHeight, 0)
                .setDuration(2500);

        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    public void cycle(View v){
        CycleInterpolator cycleInterpolator = new CycleInterpolator(10f);
        ViewPropertyAnimator anim = image.animate();
        anim.alpha(0);
        anim.setDuration(2000);
        anim.setInterpolator(cycleInterpolator);
    }
}
