package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
public class addCustomer extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8;
 Button b1;
    SQLiteDatabase sqLiteDatabase;
    database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        e1=findViewById(R.id.numberrrr);
        e2=findViewById(R.id.nameeee);
        e3=findViewById(R.id.addressss);
        e4=findViewById(R.id.mobilenumberrrr);
        e5=findViewById(R.id.dateeee);
        e8=findViewById(R.id.liter);
        e6=findViewById(R.id.priceeee);
        e7=findViewById(R.id.literrrr);

        b1=findViewById(R.id.inputdataaaa);
        g=new database(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e11=e1.getText().toString();
                String e12=e2.getText().toString();
                String e13=e3.getText().toString();
                String e14=e4.getText().toString();
                String e15=e5.getText().toString();
                String e18=e8.getText().toString();
                String e16=e6.getText().toString();
                String e17=e7.getText().toString();

                if (e11.equals("")){
                    e1.setError("Give roll number to Customer");
                }


          else if (e12.equals("")){
                    e2.setError("Enter Name");
                }

               else if (e13.equals("")){
                    e3.setError("Enter Address");
                }

                else   if (e14.equals("")){
                    e4.setError("Enter Valid Mobile Number");
                }

                else if (e15.equals("")){
                    e5.setError("Enter Today's Date");
                }
                else if (e18.equals("")){
                    e8.setError("Enter Liter");
                }

                else if (e16.equals("")){
                    e6.setError("Enter Price");
                }

                else  if (e17.equals("")){
                    e7.setError("Cow/Buffalo");
                }


                else {
                    boolean i=g.insert_data(e11,e12,e13,e14,e15,e18,e16,e17);

                    if (i==true){
                        Toast.makeText(addCustomer.this, "Successfully added", Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        e8.setText("");
                        e6.setText("");
                        e7.setText("");
                    }
                    else {
                        Toast.makeText(addCustomer.this, "Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
