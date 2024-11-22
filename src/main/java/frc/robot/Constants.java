// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  // Public = Variable or Function accessable from other classes
  // Static = The varaible or fucntion belongs to that specific class
  // Final = the value cannot be changed

  // Controller related Constants
  public static class OIConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class intakeConstants {

    // Specify the CAN ID of the motor
    public static final int intakeMotorCANId = 1;

    // Intake Motor Speed
    // We are using a REV Neo
    public static final int neoRPM = 5676;

    // PID Controller Values for Neo
    // Don't worry too much about this yet
    // Whenever you setup a brushless motor you will need these, 
    // keep the same value just change name

    // Intake PID Controller
    public static double intakeKp = 6e-5; 
    public static double intakeKi = 0.0000; 
    public static double intakeKd = 0; 
    public static double intakeKIz = 6e-5; 
    public static double intakeKFf = 0.000015;

    public static double intakeMax = 1; 
    public static double intakeMin = -1; 

    // Slew Rate for the motor
    // The max rate at which a motor value can change
    public static double intakeSlewLimit = 2; 

    // Ramp Rate for the motor
    // Smooths the motors acceleration and deceleration
    public static double intakeRampRate = 0.25;

    //


  }

}
