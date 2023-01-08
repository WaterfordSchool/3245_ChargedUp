package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LobsterRunSubsystem extends SubsystemBase{
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
    public LobsterRunSubsystem(){
        //arm motors/encoders
        armMotorBaseJoint = new TalonFX(Constants.armMotorBaseJointID);
        armMotorStretchJoint = new TalonFX(Constants.armMotorStretchJointID);
        armBaseJointEnc = new TalonFXSensorCollection(armMotorBaseJoint);
        armStretchJointEnc = new TalonFXSensorCollection(armMotorStretchJoint);

        //config PID
        armMotorBaseJoint.config_kF(0, Constants.armBasekF);
        armMotorBaseJoint.config_kP(0, Constants.armBasekP);
        armMotorBaseJoint.config_kI(0, Constants.armBasekI);
        armMotorBaseJoint.config_kD(0, Constants.armBasekD);

        armMotorStretchJoint.config_kF(0, Constants.armStretchkF);
        armMotorStretchJoint.config_kP(0, Constants.armStretchkP);
        armMotorStretchJoint.config_kI(0, Constants.armStretchkI);
        armMotorStretchJoint.config_kD(0, Constants.armStretchkD);

        //config max output
        armMotorBaseJoint.configClosedLoopPeakOutput(0, Constants.armBaseClosedMaxOutput);
        armMotorBaseJoint.configClosedloopRamp(Constants.armBaseClosedRampRate);
        armMotorStretchJoint.configClosedLoopPeakOutput(0, Constants.armStretchClosedMaxOutput);
        armMotorStretchJoint.configClosedloopRamp(Constants.armStretchClosedRampRate);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Base Arm Joint Encoder Absolute Position", armBaseJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Stretch Arm Joint Encoder Absolute Position", armStretchJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armBaseJointEnc.getIntegratedSensorPosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armBaseJointEnc.getIntegratedSensorPosition());
        SmartDashboard.putNumber(getName(), armBaseJointEnc.getIntegratedSensorVelocity());
    }
    
    public void resetArmEncoder(){
        //reset arm encoders (use in loading, low position)
        armBaseJointEnc.setIntegratedSensorPosition(0, 15);
        armStretchJointEnc.setIntegratedSensorPosition(0, 15);
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
        armMotorBaseJoint.set(ControlMode.PercentOutput, 0.4*manualArmController.getRawAxis(Constants.manualArmBaseJointAxis));
        armMotorStretchJoint.set(ControlMode.PercentOutput, 0.4*manualArmController.getRawAxis(Constants.manualArmStretchJointAxis));
    }
}
