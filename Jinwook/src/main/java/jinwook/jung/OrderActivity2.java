/*
Student ID: 300801360
Name: Jinwook Jung
 */

package jinwook.jung;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity2 extends AppCompatActivity {


    private String typeSelection = "";
    private String sizeSelection = "";
    private String toppingList = "";

    private String name = "";
    private String creditCardNumber = "";
    private String address = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        getData();
    }
    public String getData() {
        // 1. get passed intent
        Bundle bundle = getIntent().getExtras();
        //Intent intent = getIntent();

        // 2. get message value from intent
        typeSelection = bundle.getString("typeRadioButton");
        sizeSelection = bundle.getString("sizeRadioButton");
        toppingList = bundle.getString("toppingResult");


        //toppingList = intent.getStringExtra("toppingResult");

        //Show user's selection
        TextView typeTextView = (TextView)findViewById(R.id.showTypeTextView);
        TextView sizeTextView = (TextView)findViewById(R.id.showSizeTextView);
        TextView toppingTextView = (TextView)findViewById(R.id.showToppingTextView);

        typeTextView.setText(typeSelection);
        sizeTextView.setText(sizeSelection);
        toppingTextView.setText(toppingList);

        return typeSelection;


    }
    //Button Control++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void callIntent3 (View view){
        switch (view.getId()) {

            case R.id.orderActivityBackButton:
                finish();
                break;

            case R.id.orderButton:

                EditText editText1 = (EditText) findViewById(R.id.nameEditText);
                EditText editText2 = (EditText) findViewById(R.id.creditCardEditText);
                EditText editText3 = (EditText) findViewById(R.id.addressEditText);

                // USER INPUT VALIDATION +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                if(editText1.getText().toString() == "" || editText2.getText().toString() == "" || editText3.getText().toString() == "" )
                {
                    Toast.makeText(this, "Must fill out all field", Toast.LENGTH_SHORT).show();
                }
                else if (!isAlpha(editText1.getText().toString()))
                {
                    Toast.makeText(this, "Name has to be only letter and minimum 3 letters", Toast.LENGTH_SHORT).show();
                }
                else if (!editText2.getText().toString().matches("^\\d+$"))
                {
                    Toast.makeText(this, "Credit Card number must be only number", Toast.LENGTH_SHORT).show();
                }
                else if(editText2.length() != 16)
                {
                    Toast.makeText(this, "Credit Card number must be 16-digit", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(this, CheckoutActivity.class);

                    name = editText1.getText().toString();
                    creditCardNumber = editText2.getText().toString();
                    address = editText3.getText().toString();

                    //pass all information to CheckoutActivity
                    intent.putExtra("Type", typeSelection);
                    intent.putExtra("Size", sizeSelection);
                    intent.putExtra("Topping", toppingList);

                    intent.putExtra("Name", name);
                    intent.putExtra("CreditCard", creditCardNumber);
                    intent.putExtra("Address", address);

                    startActivity(intent);
                }

            default:
                break;
        }
    }
    //validate if input is only letters++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean isAlpha(String name) {

        return name.matches("[a-zA-Z]{3,30}");
    }
    //Menu inflater  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean onCreateOptionsMenu(Menu menu) {
        //this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
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
