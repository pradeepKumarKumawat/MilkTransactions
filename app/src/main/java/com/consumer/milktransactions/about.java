package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class about extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        button=findViewById(R.id.shareapp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String str="Download milk transaction app and keep record of customer:"+" https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID ;
                intent.putExtra(Intent.EXTRA_TEXT,str);
                startActivity(Intent.createChooser(intent,"Share using"));
            }
        });
    }
}