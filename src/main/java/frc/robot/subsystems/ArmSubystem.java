package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubystem extends SubsystemBase{
    public final TalonFX armMotorShoulderMaster;
    public final TalonFX armMotorShoulderSlave;
    public final TalonFX armMotorWristJoint;

    public final TalonFXSensorCollection armShoulderMasterEnc;
    public final TalonFXSensorCollection armShoulderSlaveEnc;
    public final TalonFXSensorCollection armWristJointEnc;

    //init stuff
    public ArmSubystem(){
        //arm motors/encoders
        armMotorShoulderMaster = new TalonFX(Constants.armMotorShoulderMasterID);
        armMotorShoulderSlave = new TalonFX(Constants.armMotorShoulderSlaveID);
        armMotorWristJoint = new TalonFX(Constants.armMotorWristJointID);

        armShoulderMasterEnc = new TalonFXSensorCollection(armMotorShoulderMaster);
        armShoulderSlaveEnc = new TalonFXSensorCollection(armMotorShoulderSlave);
        armWristJointEnc = new TalonFXSensorCollection(armMotorWristJoint);

        //config PID
        armMotorShoulderMaster.config_kF(0, Constants.armBasekF);
        armMotorShoulderMaster.config_kP(0, Constants.armBasekP);
        armMotorShoulderMaster.config_kI(0, Constants.armBasekI);
        armMotorShoulderMaster.config_kD(0, Constants.armBasekD);

        armMotorWristJoint.config_kF(0, Constants.armWristkF);
        armMotorWristJoint.config_kP(0, Constants.armWristkP);
        armMotorWristJoint.config_kI(0, Constants.armWristkI);
        armMotorWristJoint.config_kD(0, Constants.armWristkD);

        //config max output
        armMotorShoulderMaster.configClosedLoopPeakOutput(0, Constants.armBaseClosedMaxOutput);
        armMotorShoulderMaster.configClosedloopRamp(Constants.armBaseClosedRampRate);
        armMotorWristJoint.configClosedLoopPeakOutput(0, Constants.armWristClosedMaxOutput);
        armMotorWristJoint.configClosedloopRamp(Constants.armWristClosedRampRate);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Base Arm Joint Encoder Absolute Position", armShoulderMasterEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Wrist Arm Joint Encoder Absolute Position", armWristJointEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Base Arm Joint Encoder Position", armShoulderMasterEnc.getIntegratedSensorPosition());
        SmartDashboard.putNumber("Wrist Arm Joint Encoder Position", armWristJointEnc.getIntegratedSensorPosition());
    }
    
    public void resetEncoders(){
        //reset arm encoders (use in loading, low position)
        armShoulderMasterEnc.setIntegratedSensorPosition(0, 15);
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
        armMotorShoulderMaster.set(ControlMode.PercentOutput, 0.4*controller.getRawAxis(Constants.manualShoulderAxis));
        armMotorWristJoint.set(ControlMode.PercentOutput, 0.4*controller.getRawAxis(Constants.manualWristAxis));
    }
}
