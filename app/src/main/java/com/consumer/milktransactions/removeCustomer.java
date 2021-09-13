package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class removeCustomer extends AppCompatActivity {
    database g;
    EditText et1;
    Button bt11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_customer);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        g=new database(this);
        et1=findViewById(R.id.getrollll);
        bt11=findViewById(R.id.deleteeee);
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNumber=et1.getText().toString();
                if (rollNumber.equals("")){
                    et1.setError("Enter Roll No.");
                }
                else {
                    Boolean i=g.delete_data(rollNumber);
                    if (i==true){
                        Toast.makeText(removeCustomer.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(removeCustomer.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}