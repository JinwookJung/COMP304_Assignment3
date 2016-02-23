
package mycompany.tablelayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    */

    public boolean onOptionsItemSelected(MenuItem item)  {
        switch (item.getItemId())  {
            case R.id.start:
            //displayTextView.setText("You selected start!");
            Toast.makeText(this, "You selected start!", Toast.LENGTH_LONG).show();
             break;

            case R.id.accel:
                 Toast.makeText(this, "You selected speed up!", Toast.LENGTH_LONG).show();
                 break;

            case R.id.stop: Toast.makeText(this, "You selected stop!", Toast.LENGTH_LONG).show();
                break;

            case R.id.decel: Toast.makeText(this, "You selected decel!", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
