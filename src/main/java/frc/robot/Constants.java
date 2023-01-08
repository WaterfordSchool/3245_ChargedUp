// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
        //ramping, max/mins
        public static final double driveRampRate = 0.3;
        public static final double elevatorClosedRampRate = 0.6;
        public static final double armBaseClosedRampRate = 0.4;
        public static final double armStretchClosedRampRate = 0.4;
        public static final double armBaseClosedMaxOutput = 0.6;
        public static final double armStretchClosedMaxOutput = 0.6;
        //PID
        public static final double elevatorkF = 0.0;
        public static final double elevatorkP = 0.15;
        public static final double elevatorkI = 0.0;
        public static final double elevatorkD = 0.0;

        public static final double armBasekF = 0.0;
        public static final double armBasekP = 0.15;
        public static final double armBasekI = 0.0;
        public static final double armBasekD = 0.0;

        public static final double armStretchkF = 0.0;
        public static final double armStretchkP = 0.15;
        public static final double armStretchkI = 0.0;
        public static final double armStretchkD = 0.0;

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
