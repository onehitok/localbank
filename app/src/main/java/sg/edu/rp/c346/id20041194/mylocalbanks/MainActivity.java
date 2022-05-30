package sg.edu.rp.c346.id20041194.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Button1;
    Button Button2;
    Button Button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = findViewById(R.id.dbs);
        Button2 = findViewById(R.id.ocbc);
        Button3 = findViewById(R.id.uob);

        registerForContextMenu(Button1);
        registerForContextMenu(Button2);
        registerForContextMenu(Button3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");


        if(v==Button1){
            wordClicked="dbs";
        }
        else if(v==Button2){
            wordClicked="ocbc";
        }
        else if(v==Button3){
            wordClicked="uob";
        }
    }
    String wordClicked="";
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(i);
                Toast.makeText(MainActivity.this, "Opening website...", Toast.LENGTH_SHORT).show();
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111l));
                startActivity(intentCall);
                return true;
            }
        }else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                String url = "https://internet.ocbc.com/internet-banking/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                Toast.makeText(MainActivity.this, "Opening website...", Toast.LENGTH_SHORT).show();
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333l));
                startActivity(intentCall);
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                String url = "https://www.uobgroup.com/uobgroup/index.page";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                Toast.makeText(MainActivity.this, "Opening website...", Toast.LENGTH_SHORT).show();
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121l));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Button1.setText("DBS");
            Button2.setText("OCBC");
            Button3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            Button1.setText("星展银行");
            Button2.setText("华侨银行");
            Button3.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}