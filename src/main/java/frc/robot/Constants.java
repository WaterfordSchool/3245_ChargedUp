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
    //drive ids
        public static final int driveleft1ID = 1;
        public static final int driveleft2ID = 2;
        public static final int driveright1ID = 3;
        public static final int driveright2ID = 4;
    //motor ids
        public static final int armMotorBaseJointID = 5;
        public static final int armMotorStretchJointID = 6;
        public static final int elevatorMotorID = 7;
        public static final int lobterLeftMotorID = 8;
        public static final int lobterRightMotorID = 9;
    //gains, PID

    //driver controls
        //drive axes: 0, 2, 3
        public static final int fastButton = 1;
        public static final int slowButton = 2;
    //operator controls
        public static final int manualArmBaseJointAxis = 1;
        public static final int manualArmStretchJointAxis = 2;
        public static final int manualElevatorAxis = 3; 
    //sensors
}
