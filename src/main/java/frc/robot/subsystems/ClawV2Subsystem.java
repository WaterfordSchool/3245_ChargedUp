package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawV2Subsystem extends SubsystemBase{
    public final CANSparkMax clawv2left;
    public final CANSparkMax clawv2right;
    public final DigitalInput limSwitchClaw;

    
      public ClawV2Subsystem() {
        clawv2left = new CANSparkMax(Constants.clawRunLeftMotorID, MotorType.kBrushless);
        clawv2right = new CANSparkMax(Constants.clawRunRightMotorID, MotorType.kBrushless);
        limSwitchClaw = new DigitalInput(0);
      }
      
    @Override
    public void periodic() {
        /*SmartDashboard.putNumber("Claw Run Left Encoder Position", spinLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Claw Run Right Encoder Position", spinRight.getSelectedSensorPosition());*/
    }
    
    public void manualSpin(XboxController controller){
        //in
        if(controller.getRawButton(Constants.manualClawInButton)){
            clawv2left.set(-0.25);
            clawv2right.set(0.25);
        }
        //out
        if(controller.getRawButton(Constants.manualClawSpitButton)){
            clawv2left.set(0.25);
            clawv2right.set(-0.25);
        }
        if(!controller.getRawButton(Constants.manualClawInButton) && !controller.getRawButton(Constants.manualClawSpitButton)){
            clawv2left.set(0);
            clawv2right.set(0);
        }
    }
    public void closeWithLimSwitch(){
        if(!limSwitchClaw.get()){
            clawv2left.set(-Constants.clawContactCurrentValue);
            clawv2right.set(Constants.clawContactCurrentValue);
        }
        if(limSwitchClaw.get()){
            clawv2left.set(0);
            clawv2right.set(0);
        }
    }

    public boolean getLimSwitch(){
        return limSwitchClaw.get();
    }

    public void stopSpin(){
        clawv2left.set(0);
        clawv2right.set(0);
    }

}