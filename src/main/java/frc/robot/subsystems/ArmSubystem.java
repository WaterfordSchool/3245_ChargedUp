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
    public final TalonFX armMotorWristJoint;
    public final TalonFXSensorCollection armBaseJointEnc;
    public final TalonFXSensorCollection armWristJointEnc;
    /*TODO
    track encoder values in time based, tune appropriately
    tune PID
    think about motion magic
    */

    //wrist is stretch motor 
    //motors

    //init stuff
    public ArmSubystem(){
        //arm motors/encoders
        armMotorBaseJoint = new TalonFX(Constants.armMotorBaseJointID);
        armMotorWristJoint = new TalonFX(Constants.armMotorWristJointID);
        armBaseJointEnc = new TalonFXSensorCollection(armMotorBaseJoint);
        armWristJointEnc = new TalonFXSensorCollection(armMotorWristJoint);

        //config PID
        armMotorBaseJoint.config_kF(0, Constants.armBasekF);
        armMotorBaseJoint.config_kP(0, Constants.armBasekP);
        armMotorBaseJoint.config_kI(0, Constants.armBasekI);
        armMotorBaseJoint.config_kD(0, Constants.armBasekD);

        armMotorWristJoint.config_kF(0, Constants.armWristkF);
        armMotorWristJoint.config_kP(0, Constants.armWristkP);
        armMotorWristJoint.config_kI(0, Constants.armWristkI);
        armMotorWristJoint.config_kD(0, Constants.armWristkD);

        //config max output
        armMotorBaseJoint.configClosedLoopPeakOutput(0, Constants.armBaseClosedMaxOutput);
        armMotorBaseJoint.configClosedloopRamp(Constants.armBaseClosedRampRate);
        armMotorWristJoint.configClosedLoopPeakOutput(0, Constants.armWristClosedMaxOutput);
        armMotorWristJoint.configClosedloopRamp(Constants.armWristClosedRampRate);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Base Arm Joint Encoder Absolute Position", armBaseJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Wrist Arm Joint Encoder Absolute Position", armWristJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armBaseJointEnc.getIntegratedSensorPosition());
        SmartDashboard.putNumber("Wrist Arm Joint Encoder Position", armWristJointEnc.getIntegratedSensorPosition());
    }
    
    public void resetEncoders(){
        //reset arm encoders (use in loading, low position)
        armBaseJointEnc.setIntegratedSensorPosition(0, 15);
        armWristJointEnc.setIntegratedSensorPosition(0, 15);
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

    public void moveManual(XboxController controller){
        //move arm manually
        armMotorBaseJoint.set(ControlMode.PercentOutput, 0.4*controller.getRawAxis(Constants.manualArmBaseJointAxis));
        armMotorWristJoint.set(ControlMode.PercentOutput, 0.4*controller.getRawAxis(Constants.manualArmWristJointAxis));
    }
}
