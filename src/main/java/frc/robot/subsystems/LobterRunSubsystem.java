package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LobterRunSubsystem extends SubsystemBase{
    public final TalonSRX spinLeft;
    public final TalonSRX spinRight;
    /*public final TalonFXSensorCollection spinLeftEnc;
    public final TalonFXSensorCollection spinRightEnc;*/
    
      public LobterRunSubsystem() {
        spinLeft = new TalonSRX(Constants.lobterRunLeftMotorID);
        spinRight = new TalonSRX(Constants.lobterRunRightMotorID);
        spinLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        spinRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        
        spinLeft.config_kF(0, Constants.lobterRunkF);
        spinLeft.config_kP(0, Constants.lobterRunkP);
        spinLeft.config_kI(0, Constants.lobterRunkI);
        spinLeft.config_kD(0, Constants.lobterRunkD);

        spinRight.config_kF(0, Constants.lobterRunkF);
        spinRight.config_kP(0, Constants.lobterRunkP);
        spinRight.config_kI(0, Constants.lobterRunkI);
        spinRight.config_kD(0, Constants.lobterRunkD);

        spinLeft.configAllowableClosedloopError(0, 10, 15);
        spinRight.configAllowableClosedloopError(0, 10, 15);

        spinLeft.configClosedLoopPeakOutput(0, Constants.lobterDriveClosedMaxOutput);
        spinLeft.configClosedloopRamp(Constants.lobterDriveClosedrampRate);
        spinRight.configClosedLoopPeakOutput(0, Constants.lobterDriveClosedMaxOutput);
        spinRight.configClosedloopRamp(Constants.lobterDriveClosedrampRate);
      }
      
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Lobter Run Left Encoder Position", spinLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Lobter Run Right Encoder Position", spinRight.getSelectedSensorPosition());
    }
    public void spinLeft(){
        spinLeft.set(ControlMode.Position, spinLeft.getSelectedSensorPosition()-200);
        //spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void spinRight(){
        spinLeft.set(ControlMode.Position, spinRight.getSelectedSensorPosition()+200);
        //spinLeft.set(ControlMode.PercentOutput, 0);
    }

    public void spit(){
        spinLeft.set(ControlMode.Position, spinLeft.getSelectedSensorPosition()+200);
        spinLeft.set(ControlMode.Position, spinRight.getSelectedSensorPosition()-200);
    }
    
    public void manualSpin(XboxController controller){
        //todo: need other motor to spin in other direction for spin methods?
        if(controller.getRawButton(Constants.manualLobterLeftSpinButton)){
            spinLeft.set(ControlMode.PercentOutput, -0.25);
        }
        if(controller.getRawButton(Constants.manualLobterRightSpinButton)){
            spinRight.set(ControlMode.PercentOutput, 0.25);
        }
        if(controller.getRawButton(Constants.manualLobterSpitButton)){
            spinLeft.set(ControlMode.PercentOutput, 0.25);
            spinRight.set(ControlMode.PercentOutput, -0.25);
        }
        if(!controller.getRawButton(Constants.manualLobterLeftSpinButton) && !controller.getRawButton(Constants.manualLobterRightSpinButton) && !controller.getRawButton(Constants.manualLobterSpitButton) && !controller.getRawButton(Constants.allScoreButton)){
            spinLeft.set(ControlMode.PercentOutput, 0);
            spinRight.set(ControlMode.PercentOutput, 0);
        }
        
    }

    public void stopSpin(){
        spinLeft.set(ControlMode.PercentOutput, 0);
        spinRight.set(ControlMode.PercentOutput, 0);
    }

}