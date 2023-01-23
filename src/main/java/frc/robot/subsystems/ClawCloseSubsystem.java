package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawCloseSubsystem extends SubsystemBase{
    public final TalonFX clawCloseOpenMotor;
    public final TalonFXSensorCollection clawEnc;
    /*TODO
    track encoder values in time based, tune appropriately
    tune PID
    think about motion magic
    */

    //motors

    //init stuff
    public ClawCloseSubsystem(){
        //claw motor/encoder
        clawCloseOpenMotor = new TalonFX(Constants.clawCloseMotorID);
        clawEnc = new TalonFXSensorCollection(clawCloseOpenMotor);
        
        //config PID
        clawCloseOpenMotor.config_kF(0, Constants.clawClosekF);
        clawCloseOpenMotor.config_kP(0, Constants.clawClosekP);
        clawCloseOpenMotor.config_kI(0, Constants.clawClosekI);
        clawCloseOpenMotor.config_kD(0, Constants.clawClosekD);

        //config max output and ramping
        clawCloseOpenMotor.configClosedloopRamp(Constants.clawCloseClosedRampRate);
        clawCloseOpenMotor.configClosedLoopPeakOutput(0, Constants.clawCloseMaxVal);        
    }

    @Override
    public void periodic() {
        //put encoder positions
        
        //put current value
        
    }
    
    public void resetArmEncoder(){
        //reset arm encoders (use in loading, low position)
        clawEnc.setIntegratedSensorPosition(0, 10);
    }

    public void setCone(){
        //set arm to low encoder positions
    }

    public void setCube(){
        //setarm to mid encoder positions
    }

    public void moveManual(XboxController controller){
        //move arm manually
        clawCloseOpenMotor.set(ControlMode.PercentOutput, Constants.clawCloseMaxVal*controller.getRawAxis(Constants.manualClawCloseAxis));
    }

    public void drop(){
        //set arms to open position
    }

    public void currentOutputMode(){
        //1. track current of each motor
        //2. set threshhold
        //3. probably put this in time based
        if(clawCloseOpenMotor.getStatorCurrent()>Constants.clawContactCurrentValue){
            clawCloseOpenMotor.set(ControlMode.PercentOutput, 0);
        }
        if(clawCloseOpenMotor.getStatorCurrent()<Constants.clawContactCurrentValue){
            clawCloseOpenMotor.set(ControlMode.PercentOutput, Constants.clawNoContactSpeed);
        }
    }
}
