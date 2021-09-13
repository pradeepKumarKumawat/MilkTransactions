package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
public class viewData extends AppCompatActivity {
    ArrayList<String>  listItem;
    ArrayAdapter adapter;
    ListView userlist;
    database g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listItem=new ArrayList<>();
        g=new database(this);
        userlist=findViewById(R.id.users_list);
        getinfo();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor=g.getinfo();
                final StringBuffer stringBuffer=new StringBuffer();
                while (cursor.moveToNext()){
                    stringBuffer.append("\n"+" "+cursor.getString(1)+" . "+"\n");
                    stringBuffer.append(" Name  :  "+cursor.getString(2)+"\n");
                    stringBuffer.append(" Address  :  "+cursor.getString(3)+"\n");
                    stringBuffer.append(" Mobile Number  :  "+cursor.getString(4)+"\n");
                    stringBuffer.append(" Date  :  "+cursor.getString(5)+"\n");
                    stringBuffer.append(" Liter  :  "+cursor.getString(6)+"\n");
                    stringBuffer.append(" Price  :  "+cursor.getString(7)+"\n");
                    stringBuffer.append(" Animal  :  "+cursor.getString(8)+"\n\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(viewData.this);
                builder.setCancelable(true);
                builder.setTitle("Milk Transaction");
                builder.setMessage(stringBuffer.toString());
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, (Serializable) stringBuffer);
                        startActivity(Intent.createChooser(intent,"Share using"));
                    }
                });
                builder.show();
            }
        });
    }
 private void getinfo() {
        Cursor cursor=g.getinfo();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No data to Show", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(2));
            }
            adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            userlist.setAdapter(adapter);
        }
    }
}