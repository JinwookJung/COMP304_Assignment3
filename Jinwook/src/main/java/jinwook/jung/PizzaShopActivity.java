/*
Student ID: 300801360
Name: Jinwook Jung
 */

package jinwook.jung;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class PizzaShopActivity extends AppCompatActivity {


    private RadioGroup radioGroupA, radioGroupB;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    private String selection;
    private Menu menu;
    private ImageView pizzaImage;
    private String toppingResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_shop_activity);

        getData();

        setImageView();

    }

    //Set image view +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void setImageView() {
        pizzaImage = (ImageView) findViewById(R.id.pizzaImageView);

        switch (selection) {
            case "domino":
                pizzaImage.setBackgroundResource(R.drawable.domino);
                break;
            case "pizzahut":
                pizzaImage.setBackgroundResource(R.drawable.pizzahut);
                break;
            case "pizzapizza":
                pizzaImage.setBackgroundResource(R.drawable.pizzapizza);
                break;
        }
    }

    //retrieve data from JinwookActivity +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void getData() {

        Intent intent = getIntent();
        selection = intent.getStringExtra("pizzaRadioButton");

    }

    //Button Control ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void callIntent2(View view) {

        switch (view.getId()) {
            case R.id.nextButtonPizzaShopActivity:


                //Type and Size Radio Group+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                radioGroupA = (RadioGroup) findViewById(R.id.typeRadioGroup);
                radioGroupB = (RadioGroup) findViewById(R.id.sizeRadioGroup);

                //Topping Selection CheckBox +++++++++++++++++++++++++++++++++++++++++++++++++
                checkBox1 = (CheckBox) findViewById(R.id.pepeperoniCheckBox);
                checkBox2 = (CheckBox) findViewById(R.id.onionCheckBox);
                checkBox3 = (CheckBox) findViewById(R.id.garlicCheckBox);
                checkBox4 = (CheckBox) findViewById(R.id.oliveCheckBox);
                checkBox5 = (CheckBox) findViewById(R.id.mushroomCheckBox);
                checkBox6 = (CheckBox) findViewById(R.id.potatoCheckBox);


                if (radioGroupA.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "You must select pizza type", Toast.LENGTH_SHORT).show();
                } else if (radioGroupB.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "You must select pizza size", Toast.LENGTH_SHORT).show();
                } else if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() &&
                        !checkBox4.isChecked() && !checkBox5.isChecked() && !checkBox6.isChecked()) {
                    Toast.makeText(this, "You must select at least one topping", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), OrderActivity2.class);

                    int radioGroupAId = (radioGroupA).getCheckedRadioButtonId();
                    int radioGroupBId = (radioGroupB).getCheckedRadioButtonId();

                    //put Type RadioButton value to intent+++++++++++++++++++++++++

                    if (radioGroupAId == R.id.neapolitanRadioButton) {
                        intent.putExtra("typeRadioButton", "Neapolitan");
                    } else if (radioGroupAId == R.id.deepDishRadioButton) {
                        intent.putExtra("typeRadioButton", "Deep Dish");
                    } else {
                        intent.putExtra("typeRadioButton", "New York style");
                    }


                    //put Size RadioButton value to intent+++++++++++++++++++++++++

                    if (radioGroupBId == R.id.smallRadioButton) {
                        intent.putExtra("sizeRadioButton", "Small");
                    } else if (radioGroupAId == R.id.mediumRadioButton) {
                        intent.putExtra("sizeRadioButton", "Medium");
                    } else {
                        intent.putExtra("sizeRadioButton", "Large");
                    }

                    //put Topping checkbox value to intent+++++++++++++++++++++++++
                    if (checkBox1.isChecked()) {
                        toppingResult = toppingResult + " Pepperoni ";
                    }
                    if (checkBox2.isChecked()) {
                        toppingResult = toppingResult + " Onion ";
                    }
                    if (checkBox3.isChecked()) {
                        toppingResult = toppingResult + " Garlic ";
                    }
                    if (checkBox4.isChecked()) {
                        toppingResult = toppingResult + " Olive ";
                    }
                    if (checkBox5.isChecked()) {
                        toppingResult = toppingResult + " Mushroom ";
                    }
                    if (checkBox6.isChecked()) {
                        toppingResult = toppingResult + " Potato ";
                    }

                    intent.putExtra("toppingResult", toppingResult);

                    //Start next OrderActivity   +++++++++++++++++++++++++++++++++++++++++++++++++
                    startActivity(intent);


                }

                break;

            default:
                break;

        }
    }

    //Menu inflater  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //when Actionbar menu selected   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
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

    //Prepare menu++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (selection != null) {
            if (selection == "domino") {
                MenuItem item = menu.findItem(R.id.menuPizza);
                item.setIcon(R.drawable.domino);
            } else if (selection == "pizzahut") {
                MenuItem item = menu.findItem(R.id.menuPizza);
                item.setIcon(R.drawable.pizzahut);
            } else if (selection == "pizzapizza"){
                MenuItem item = menu.findItem(R.id.menuPizza);
                item.setIcon(R.drawable.pizzapizza);
            }

        }
        return true;
    }
}




