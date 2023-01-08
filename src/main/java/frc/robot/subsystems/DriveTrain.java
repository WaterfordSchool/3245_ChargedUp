package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX left1;
    private WPI_TalonSRX left2;
    private WPI_TalonSRX right1;
    private WPI_TalonSRX right2;

    private MotorControllerGroup leftDrive; 
    private MotorControllerGroup rightDrive; 

    private DifferentialDrive dT;
    
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    left1 = new WPI_TalonSRX(Constants.driveleft1ID);
    left2 = new WPI_TalonSRX(Constants.driveleft2ID);
    right1 = new WPI_TalonSRX(Constants.driveright1ID);
    right2 = new WPI_TalonSRX(Constants.driveright2ID);


    leftDrive = new MotorControllerGroup(left1, left2);
    rightDrive = new MotorControllerGroup(right1, right2);

    dT = new DifferentialDrive(leftDrive, rightDrive);
    
     //ramping
     final double t = 0.3;
     left1.configOpenloopRamp(t);
     left2.configOpenloopRamp(t);
     right1.configOpenloopRamp(t);
     right2.configOpenloopRamp(t);
 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(XboxController driveController, double kSpeed) {
    dT.arcadeDrive(driveController.getRawAxis(0) * kSpeed, driveController.getRawAxis(3) * kSpeed);
    if(driveController.getRawAxis(2) > 0){
    dT.arcadeDrive(driveController.getRawAxis(0) * kSpeed, -driveController.getRawAxis(2) * kSpeed);
  }
}
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}