package com.jasonstarling.inheritanceexample;

import android.util.Log;

public abstract class AlienShip {

  private static int numShips;
  public String shipName;
  private int shieldStrength;

  public AlienShip(int shieldStrength) {
    Log.i("Location", "AlienShip constructor");
    numShips++;
    setShieldStrength(shieldStrength);
  }

  public static int getNumShips() {
    return numShips;
  }

  public abstract void fireWeapon();
  // Ahh my body! Where is it?

  public int getShieldStrength() {
    return this.shieldStrength;
  }

  private void setShieldStrength(int shieldStrength) {
    this.shieldStrength = shieldStrength;
  }

  public void hitDetected() {
    shieldStrength -= 25;
    Log.i("Incoming", "Bam!!");
    if (shieldStrength == 0) {
      destroyShip();
    }
  }

  private void destroyShip() {
    numShips--;
    Log.i("Explosion", this.shipName + " destroyed");
  }
}
