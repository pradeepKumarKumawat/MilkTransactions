package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class updateDetail extends AppCompatActivity {

    EditText  e1,e2,e3,e4,e5,e6,e7,e8;
    Button button;
    database g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_detail);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        e1=findViewById(R.id.role);
        e2=findViewById(R.id.nam);
        e3=findViewById(R.id.addre);
        e4=findViewById(R.id.mobil);
        e5=findViewById(R.id.dat);
        e8=findViewById(R.id.literss);
        e6=findViewById(R.id.pri);
        e7=findViewById(R.id.lite);
        button=findViewById(R.id.nextttt);
        g=new database(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed1=e1.getText().toString();
                String ed2=e2.getText().toString();
                String ed3=e3.getText().toString();
                String ed4=e4.getText().toString();
                String ed5=e5.getText().toString();
                String ed8=e8.getText().toString();
                String ed6=e6.getText().toString();
                String ed7=e7.getText().toString();
                if (ed1.equals("")){
                    e1.setError("Enter roll no.");
                }
                else if (ed2.equals("")){
                    e2.setError("Enter Name");
                }
                else if (ed3.equals("")){
                    e3.setError("Enter Address");
                }
                else   if (ed4.equals("")){
                    e4.setError("Enter Valid Mobile Number");
                }
                else if (ed5.equals("")){
                    e5.setError("Enter Today's Date");
                }
                else if (ed8.equals("")){
                    e8.setError("Enter Liter");
                }
                else if (ed6.equals("")){
                    e6.setError("Enter Price");
                }
                else  if (ed7.equals("")){
                    e7.setError("Enter Liter");
                }
                else {
                    Boolean i=g.update_data(ed1,ed2,ed3,ed4,ed5,ed8,ed6,ed7);
                    if (i==true){
                        Toast.makeText(updateDetail.this, "Data Update Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(updateDetail.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}