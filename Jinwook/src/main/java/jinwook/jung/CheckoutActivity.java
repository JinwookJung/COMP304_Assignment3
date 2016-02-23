/*
Student ID: 300801360
Name: Jinwook Jung
 */

package jinwook.jung;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);
        //showCheckOutInfo();
    }

    public void showCheckOutInfo() {
        // 1. get passed intent
        Intent intent2 = getIntent();

        // 2. get message value from intent
        String typeSelection = intent2.getStringExtra("Type");
        String sizeSelection = intent2.getStringExtra("Size");
        String toppingList = intent2.getStringExtra("Topping");

        String cusName = intent2.getStringExtra("Name");
        String cusCreditCard = intent2.getStringExtra("CreditCard");
        String cusAddress = intent2.getStringExtra("Address");

        //Show user's selection

        TextView typeTextView = (TextView)findViewById(R.id.showType);
        TextView sizeTextView = (TextView)findViewById(R.id.showSize);
        TextView toppingTextView = (TextView)findViewById(R.id.showTopping);

        TextView nameTextView = (TextView)findViewById(R.id.showTypeTextView);
        TextView creditTextView = (TextView)findViewById(R.id.showSizeTextView);
        TextView addressTextView = (TextView)findViewById(R.id.showToppingTextView);

        //set Textview
        typeTextView.setText(typeSelection);
        sizeTextView.setText(sizeSelection);
        toppingTextView.setText(toppingList);
        nameTextView.setText(cusName);
        creditTextView.setText(cusCreditCard);
        addressTextView.setText(cusAddress);


        // 6. show status on Toast
        Toast toast = Toast.makeText(this, typeSelection + sizeSelection + toppingList + cusName + cusCreditCard + cusAddress, Toast.LENGTH_LONG);
        toast.show();

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

    public void callIntent4(View view) {

        switch (view.getId()) {
            case R.id.checkoutButton:
                new AlertDialog.Builder(this)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to confirm your order")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(CheckoutActivity.this, JinwookActivity.class));
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;

            default:
                break;

        }
    }
}
