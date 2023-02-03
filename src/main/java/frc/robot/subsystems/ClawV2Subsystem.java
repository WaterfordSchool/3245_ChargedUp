package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawV2Subsystem extends SubsystemBase{
    public final CANSparkMax spinLeft;
    public final CANSparkMax spinRight;
    /*public final TalonFXSensorCollection spinLeftEnc;
    public final TalonFXSensorCollection spinRightEnc;*/
    
      public ClawV2Subsystem() {
        spinLeft = new CANSparkMax(Constants.clawRunLeftMotorID, MotorType.kBrushless);
        spinRight = new CANSparkMax(Constants.clawRunRightMotorID, MotorType.kBrushless);
      }
      
    @Override
    public void periodic() {
        /*SmartDashboard.putNumber("Claw Run Left Encoder Position", spinLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Claw Run Right Encoder Position", spinRight.getSelectedSensorPosition());*/
    }
    
    public void manualSpin(XboxController controller){
        //todo: need other motor to spin in other direction for spin methods?
        if(controller.getRawButton(Constants.manualClawLeftSpinButton)){
            spinLeft.set(-0.25);
        }
        if(controller.getRawButton(Constants.manualClawRightSpinButton)){
            spinRight.set(0.25);
        }
        if(controller.getRawButton(Constants.manualClawSpitButton)){
            spinLeft.set(0.25);
            spinRight.set(-0.25);
        }
        if(!controller.getRawButton(Constants.manualClawLeftSpinButton) && !controller.getRawButton(Constants.manualClawRightSpinButton) && !controller.getRawButton(Constants.manualClawSpitButton) && !controller.getRawButton(Constants.allScoreButton)){
            spinLeft.set(0);
            spinRight.set(0);
        }
    }

    public void stopSpin(){
        spinLeft.set(0);
        spinRight.set(0);
    }

}