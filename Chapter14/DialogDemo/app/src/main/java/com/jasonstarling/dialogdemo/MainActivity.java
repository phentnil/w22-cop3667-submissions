package com.jasonstarling.dialogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /* Let's listen for clicks on our regular Button.
     * We can do this with an anonymous class.
     */

    Button button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        MyDialog myDialog = new MyDialog();

        // This calls onCreateDialog
        myDialog.show(getSupportFragmentManager(), "123");
      }
    });
  }
}