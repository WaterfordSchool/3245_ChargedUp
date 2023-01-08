package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubystem extends SubsystemBase{
    public final TalonFX armMotorBaseJoint;
    public final TalonFX armMotorStretchJoint;
    public final TalonFXSensorCollection armBaseJointEnc;
    public final TalonFXSensorCollection armStretchJointEnc;
    /*TODO
    track encoder values in time based, tune appropriately
    tune PID
    think about motion magic
    */

    //motors

    //init stuff
    public ArmSubystem(){
        //arm motors/encoders
        armMotorBaseJoint = new TalonFX(Constants.armMotorBaseJointID);
        armMotorStretchJoint = new TalonFX(Constants.armMotorStretchJointID);
        armBaseJointEnc = new TalonFXSensorCollection(armMotorBaseJoint);
        armStretchJointEnc = new TalonFXSensorCollection(armMotorStretchJoint);
        //config PID
        //config max output
        armMotorBaseJoint.configClosedLoopPeakOutput(0, 0.4);
        armMotorStretchJoint.configClosedLoopPeakOutput(0, 0.4);
        armMotorBaseJoint.configOpenloopRamp(.4);
        armMotorStretchJoint.configOpenloopRamp(0.4);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Base Arm Joint Encoder Absolute Position", armBaseJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Stretch Arm Joint Encoder Absolute Position", armStretchJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armBaseJointEnc.getIntegratedSensorPosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armBaseJointEnc.getIntegratedSensorPosition());
    }
    
    public void resetArmEncoder(){
        //reset arm encoders (use in loading, low position)
    }

    public void moveLow(){
        //set arm to low encoder positions
    }

    public void moveMid(){
        //setarm to mid encoder positions
    }

    public void moveHigh(){
        //set arm to high encoder positions
    }

    public void moveBack(){
        //set arm to 0 encoder positions
    }

    public void moveArmManually(XboxController manualArmController){
        //move arm manually
        armMotorBaseJoint.set(ControlMode.PercentOutput, 0.3*manualArmController.getRawAxis(Constants.manualArmBaseJointAxis));
        armMotorStretchJoint.set(ControlMode.PercentOutput, 0.3*manualArmController.getRawAxis(Constants.manualArmStretchJointAxis));
    }
}
