/* Student ID: 300801360
Name: Jinwook Jung
*
* */

package jinwook.jung;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;


public class JinwookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinwook);
    }


    //Button control++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void callIntent (View view){
        switch (view.getId()) {
            case R.id.nextButton:

                RadioGroup pizzaRadioGroup = (RadioGroup) findViewById(R.id.pizzaRadioGroup);

                if(pizzaRadioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(this, "You must select pizza type", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int pizzaRadioGroupId = (pizzaRadioGroup).getCheckedRadioButtonId();

                    Intent intent = new Intent(getApplicationContext(), PizzaShopActivity.class);

                    //put RadioButton value to intent+++++++++++++++++++++++++

                    if(pizzaRadioGroupId == R.id.dominoRadioButton)
                    {
                        intent.putExtra("pizzaRadioButton", "domino");
                    }
                    else if(pizzaRadioGroupId == R.id.pizzaHutRadioButton)
                    {
                        intent.putExtra("pizzaRadioButton", "pizzahut");
                    }
                    else
                    {
                        intent.putExtra("pizzaRadioButton", "pizzapizza");
                    }

                    startActivity(intent);
                }

                break;

            case R.id.backButton:
                finish();
                break;
            /*
            case R.id.orderActivityBackButton:
                finish();
                break;
            case R.id.orderButton:
                startActivity(new Intent(this, CheckoutActivity.class));
                break;
                */

            default:
                break;
        }
    }

    //Menu inflater  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
    }

    //when Actionbar menu selected   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean onOptionsItemSelected(MenuItem item)  {
    Intent intent = null;

    switch (item.getItemId())  {
        case R.id.menuHelp:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://centennialcollege.ca"));
            startActivity(intent);
            break;

        case R.id.menuPizza:
            Toast.makeText(this, "You selected speed up!", Toast.LENGTH_LONG).show();


            break;

        case R.id.menuName:
            Toast.makeText(this, "Do you want pizza?", Toast.LENGTH_LONG).show();
            break;
    }
    return true;
    }

}
