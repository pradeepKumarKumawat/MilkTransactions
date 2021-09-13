package com.consumer.milktransactions;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        drawerLayout=findViewById(R.id.drawer_layout);

    }

    public void clickmenu(View view){
     openDrawer(drawerLayout);
    }

    public void clickabout(View view){
        reuseActivity(this,about.class);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

  public void clicklogo(View view){
        closeDrawer(drawerLayout);
  }
  public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
  }
  public void clickhome(View view){
        recreate();
  }
  public void clickadd(View view){
        reuseActivity(this,addCustomer.class);
  }
  public void clickview(View view){
        reuseActivity(this,viewData.class);
  }
  public void clickupdate(View view){
        reuseActivity(this,updateDetail.class);
  }
  public void clickremove(View view){
        reuseActivity(this,removeCustomer.class);
  }
  public static void reuseActivity(Activity activity,Class aclass){
      Intent intent=new Intent(activity,aclass);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      activity.startActivity(intent);
  }


    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }

}