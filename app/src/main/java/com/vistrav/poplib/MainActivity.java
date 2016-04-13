package com.vistrav.poplib;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vistrav.pop.Pop;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPop(View view) {
        if (view.getId() == R.id.button_normal) {
            Pop.on(this).with().title(R.string.title).body(R.string.body)
                    .when(new Pop.Yah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Yah button clicked", Toast.LENGTH_LONG).show();
                        }
                    }).show();
        } else if (view.getId() == R.id.button_no_title) {
            Pop.on(this).with().body(R.string.body)
                    .when(new Pop.Yah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Yah button clicked", Toast.LENGTH_LONG).show();
                        }
                    }).show();
        } else if (view.getId() == R.id.button_cust_layout) {
            Pop.on(this)
                    .with()
                    .icon(R.mipmap.ic_launcher)
                    .cancelable(false)
                    .title(R.string.title)
                    .layout(R.layout.custom_pop)
                    .when(new Pop.Yah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            EditText etName = (EditText) view.findViewById(R.id.et_name);
                            Toast.makeText(getBaseContext(), "Name :: " + etName.getText(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .when(R.string.nah_button, new Pop.Nah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Nah button clicked", Toast.LENGTH_LONG).show();
                        }
                    })
                    .show(new Pop.View() {
                        @Override
                        public void prepare(View view) { // assign value to view element
                            EditText etName = (EditText) view.findViewById(R.id.et_name);
                            Log.i(TAG, "etName :: " + etName.getText());
                            etName.setText("Test Name 123");
                        }
                    });
        } else if (view.getId() == R.id.button_no_button) {
            Pop.on(this).with().title(R.string.title).body(R.string.body).show();
        }
    }
}

