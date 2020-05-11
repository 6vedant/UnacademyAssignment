package xyz.vedant.unacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import xyz.vedant.unacademy.libs.CircleProgressBar;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.custom_progressBar)  CircleProgressBar circleProgressBar;
    EditText et_progress;
    Button button_setprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleProgressBar = (CircleProgressBar)findViewById(R.id.custom_progressBar);
        et_progress = (EditText)findViewById(R.id.progress_et);
        button_setprogress = (Button)findViewById(R.id.set_progress_button);

        button_setprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(et_progress.getText().toString().trim())){

                }else{
                    try{
                        int progress = Integer.parseInt(et_progress.getText().toString().trim());
                        ObjectAnimator.ofInt(circleProgressBar, "progress", progress).start();
                        circleProgressBar.setProgress(progress);
                        setProgressAnimate(circleProgressBar, progress);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void setProgressAnimate(CircleProgressBar pb, int progressTo)
    {
        ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", (int) 0, progressTo);
        animation.setDuration(750);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.start();
    }
}
