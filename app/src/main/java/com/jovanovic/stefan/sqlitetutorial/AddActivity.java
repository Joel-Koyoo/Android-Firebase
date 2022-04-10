package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText product_name, Quantity, price;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        product_name = findViewById(R.id.Product_name);
        Quantity = findViewById(R.id.Quantity);
        price = findViewById(R.id.Price);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = product_name.getText ().toString ();
                String _quantity = Quantity.getText ().toString ();
                int _price = Integer.parseInt ( price.getText ().toString () );

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addItem (_name, _quantity, _price);
            }
        });
    }
}
