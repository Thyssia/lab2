package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main_linear);

        //Now that the screen was loaded, use findViewByid() to
        // get load the objects in Java:
        TextView firstText = findViewById(R.id.viewtext1);

        EditText theEdit = findViewById(R.id.edittext1);
        CheckBox firstCheck = findViewById(R.id.checkBox2);

        final Button btn = findViewById(R.id.button3);
        btn.setOnClickListener( (click) -> {
            firstText.setText(theEdit.getText());
            Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show();
        });

        firstCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton firstCheck, boolean b) {
                String message = getResources().getString(R.string.snack_bar) +" ";
                message += b ? getResources().getString(R.string.on) : getResources().getString(R.string.off);

                Snackbar.make(firstCheck, message, Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                firstCheck.setChecked(!firstCheck.isChecked());
                            }
                        }).show();
            }
        });
    }
}
