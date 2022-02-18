package com.jasonstarling.accessscopethisandstatic;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // every time we do this the constructor runs
    AlienShip girlShip = new AlienShip();
    AlienShip boyShip = new AlienShip();

    // Look no objects but using the static method
    Log.i("numShips", "" + AlienShip.getNumShips());

    // This works because shipName is public
    girlShip.shipName = "Corrine Yu";
    boyShip.shipName = "Andre LaMothe";

    // This won't work because shieldStrength is private
    // girlShip.shieldStrength = 999;

    // But we have a public getter
    Log.i("girlShip shieldStrength", "" + girlShip.getShieldStrength());
    Log.i("boyShip shieldStrength", "" + boyShip.getShieldStrength());

    // And we can't do this because it's private
    // boyShip.setShieldStrength(1000000);

    // let's shoot some ships
    girlShip.hitDetected();

    Log.i("girlShip shieldStrength", "" + girlShip.getShieldStrength());
    Log.i("boyShip shieldStrength", "" + boyShip.getShieldStrength());

    boyShip.hitDetected();
    boyShip.hitDetected();
    boyShip.hitDetected();

    Log.i("girlShip shieldStrength", "" + girlShip.getShieldStrength());
    Log.i("boyShip shieldStrength", "" + boyShip.getShieldStrength());

    boyShip.hitDetected(); //Ahhh!

    Log.i("girlShip shieldStrength", "" + girlShip.getShieldStrength());
    Log.i("boyShip shieldStrength", "" + boyShip.getShieldStrength());

    Log.i("numShips", "" + AlienShip.getNumShips());
  }
}