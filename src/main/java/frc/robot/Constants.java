// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    //drive ids
        public static final int driveleft1ID = 1;
        public static final int driveleft2ID = 2;
        public static final int driveleft3ID = 3;
        public static final int driveright1ID = 4;
        public static final int driveright2ID = 5;
        public static final int driveright3ID = 6;
    //motor ids
        public static final int armMotorBaseJointID = 5;
        public static final int armMotorWristJointID = 6;

        public static final int elevatorMotorID = 7;

        public static final int clawRunLeftMotorID = 8;
        public static final int clawRunRightMotorID = 9;
        public static final int clawCloseMotorID = 10;

        public static final int tiltMotorID = 12;
    //gains, PID
        //ramping, max/mins
        public static final double driveRampRate = 0.3;

        public static final double elevatorClosedRampRate = 0.4;
        public static final double elevatorClosedMaxVal = 0.5;

        public static final double clawCloseClosedRampRate = 0.4;
        public static final double clawCloseMaxVal = 0.3;
        public static final double clawContactCurrentValue = 0;
        public static final double clawNoContactSpeed = 0.1;

        public static final double armBaseClosedRampRate = 0.4;
        public static final double armWristClosedRampRate = 0.4;
        public static final double armBaseClosedMaxOutput = 0.3;
        public static final double armWristClosedMaxOutput = 0.3;

        public static final double clawDriveClosedrampRate = 0.4;
        public static final double clawDriveClosedMaxOutput = 0.15;

        public static final double tiltClosedRampRate = 0.4;
        public static final double tiltMaxOutput = 0.2;
        //PID
        public static final double elevatorkF = 0.0;
        public static final double elevatorkP = 0.15;
        public static final double elevatorkI = 0.0;
        public static final double elevatorkD = 0.0;

        public static final double armBasekF = 0.0;
        public static final double armBasekP = 0.15;
        public static final double armBasekI = 0.0;
        public static final double armBasekD = 0.0;

        public static final double armWristkF = 0.0;
        public static final double armWristkP = 0.15;
        public static final double armWristkI = 0.0;
        public static final double armWristkD = 0.0;

        public static final double tiltkF = 0.0;
        public static final double tiltkP = 0.15;
        public static final double tiltkI = 0.0;
        public static final double tiltkD = 0.0;

        public static final double clawRunkF = 0.0;
        public static final double clawRunkP = 0.15;
        public static final double clawRunkI = 0.0;
        public static final double clawRunkD = 0.0;

        public static final double clawClosekF = 0.0;
        public static final double clawClosekP = 0.15;
        public static final double clawClosekI = 0.0;
        public static final double clawClosekD = 0.0;


    //driver controls
        //drive axes: 0, 2, 3
        public static final int fastButton = 1;
        public static final int slowButton = 2;
    //operator controls
        //axes
        public static final int manualArmBaseJointAxis = 1;
        public static final int manualArmWristJointAxis = 2;

        public static final int manualElevatorAxis = 3; 

        public static final int manualClawCloseAxis = 4;

        public static final int manualTiltAxis = 6;

        //buttons
        public static final int manualClawLeftSpinButton = 1;
        public static final int manualClawRightSpinButton = 2;
        public static final int manualClawSpitButton = 3;
        public static final int allScoreButton = 4;
        public static final int currentSlideButton = 5;

        
    //sensors
}
