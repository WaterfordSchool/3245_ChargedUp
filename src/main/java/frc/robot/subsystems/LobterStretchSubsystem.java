package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LobterStretchSubsystem extends SubsystemBase{
    public final CANSparkMax lobterStretchLeft;
    public final CANSparkMax lobterStretchRight;
    public final SparkMaxPIDController stretchLeftPID;
    public final SparkMaxPIDController stretchRightPID;
    private final RelativeEncoder stretchLeftEnc;
    private final RelativeEncoder stretchRightEnc;
    /*TODO
    track encoder values in time based, tune appropriately
    tune PID
    think about motion magic
    */

    //motors

    //init stuff
    public LobterStretchSubsystem(){
        //arm motors/encoders
        lobterStretchLeft = new CANSparkMax(Constants.lobterStretchMotorLeftID , MotorType.kBrushless);
        lobterStretchRight = new CANSparkMax(Constants.lobterStretchMotorRightID, MotorType.kBrushless);
        stretchLeftPID = lobterStretchLeft.getPIDController();
        stretchRightPID = lobterStretchRight.getPIDController();
        stretchLeftEnc = lobterStretchLeft.getEncoder();
        stretchRightEnc = lobterStretchRight.getEncoder();

        //config PID
        stretchLeftPID.setFF(Constants.lobterStretchLeftkF);
        stretchLeftPID.setP(Constants.lobterStretchLeftkP);
        stretchLeftPID.setI(Constants.lobterStretchLeftkI);
        stretchLeftPID.setD(Constants.lobterStretchLeftkD);

        stretchRightPID.setFF(Constants.lobterStretchRightkF);
        stretchRightPID.setP(Constants.lobterStretchRightkP);
        stretchRightPID.setI(Constants.lobterStretchRightkI);
        stretchRightPID.setD(Constants.lobterStretchRightkD);

        //config max output
        lobterStretchLeft.setClosedLoopRampRate(Constants.lobterStretchClosedRampRate);
        stretchLeftPID.setOutputRange(-Constants.lobterStretchMaxVal, Constants.lobterStretchMaxVal);
        lobterStretchRight.setClosedLoopRampRate(Constants.lobterStretchClosedRampRate);
        stretchRightPID.setOutputRange(-Constants.lobterStretchMaxVal, Constants.lobterStretchMaxVal);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Stretch Left Encoder Position", stretchLeftEnc.getPosition());
        SmartDashboard.putNumber("Stretch Left Encoder Position Conversion Factor", stretchLeftEnc.getPositionConversionFactor());
        SmartDashboard.putNumber("Stretch Left Velocity", stretchLeftEnc.getVelocity());
        SmartDashboard.putNumber("Stretch Left Encoder Counts per Rev", stretchLeftEnc.getCountsPerRevolution());

        SmartDashboard.putNumber("Stretch Right Encoder Position", stretchRightEnc.getPosition());
        SmartDashboard.putNumber("Stretch Right Encoder Position Conversion Factor", stretchRightEnc.getPositionConversionFactor());
        SmartDashboard.putNumber("Stretch Right Velocity", stretchRightEnc.getVelocity());
        SmartDashboard.putNumber("Stretch Right Encoder Counts per Rev", stretchRightEnc.getCountsPerRevolution());

        SmartDashboard.putNumber("Stretch Left Current", lobterStretchLeft.getOutputCurrent());
        SmartDashboard.putNumber("Stretch Right Current", lobterStretchRight.getOutputCurrent());
    }
    
    public void resetArmEncoder(){
        //reset arm encoders (use in loading, low position)
        stretchLeftEnc.setPosition(0);
        stretchRightEnc.setPosition(0);
    }

    public void setCone(){
        //set arm to low encoder positions
    }

    public void setCube(){
        //setarm to mid encoder positions
    }

    public void moveManual(XboxController controller){
        //move arm manually
        lobterStretchLeft.set(-Constants.lobterStretchMaxVal*controller.getRawAxis(Constants.manualElevatorAxis));
        lobterStretchRight.set(Constants.lobterStretchMaxVal*controller.getRawAxis(Constants.manualElevatorAxis));
    }

    public void drop(){
        //set arms to open position
    }

    public void currentOutputMode(){
        //1. track current of each motor
        //2. set threshhold
        //3. probably put this in time based
        if(lobterStretchLeft.getOutputCurrent()>Constants.lobterContactCurrentValue){
            lobterStretchLeft.set(0);
        }
        if(lobterStretchRight.getOutputCurrent()>Constants.lobterContactCurrentValue){ 
            lobterStretchRight.set(0);
        }
        if(lobterStretchRight.getOutputCurrent()<Constants.lobterContactCurrentValue && lobterStretchLeft.getOutputCurrent()<Constants.lobterContactCurrentValue){ 
            lobterStretchLeft.set(-0.2);
            lobterStretchRight.set(0.2);
        }
    }
}
