package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubystem extends SubsystemBase{
    public final TalonFX armMotorBaseJoint;
    public final TalonFX armMotorStretchJoint;
    /*TODO
    attach(?) encoder
    track encoder values in time based, tune appropriately
    tune PID
    think about motion magic
    */

    //motors

    //init stuff
    public ArmSubystem(){
        //arm motors
        armMotorBaseJoint = new TalonFX(Constants.armMotorBaseJointID);
        armMotorStretchJoint = new TalonFX(Constants.armMotorStretchJointID);
        //config encoder
        //config PID
        //config sensor phase
        //set max voltage motor limit
    }

    @Override
    public void periodic() {}
    
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
