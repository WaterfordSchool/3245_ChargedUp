package frc.robot.subsystems;

import java.util.concurrent.CancellationException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
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
        SmartDashboard.putNumber("Elevator Encoder Position", stretchLeftEnc.getPosition());
        SmartDashboard.putNumber("Elevator Encoder Position Conversion Factor", stretchLeftEnc.getPositionConversionFactor());
        SmartDashboard.putNumber("Elevator Velocity", stretchLeftEnc.getVelocity());
        SmartDashboard.putNumber("Elevator Encoder Counts per Rev", stretchLeftEnc.getCountsPerRevolution());

        SmartDashboard.putNumber("Elevator Encoder Position", stretchRightEnc.getPosition());
        SmartDashboard.putNumber("Elevator Encoder Position Conversion Factor", stretchRightEnc.getPositionConversionFactor());
        SmartDashboard.putNumber("Elevator Velocity", stretchRightEnc.getVelocity());
        SmartDashboard.putNumber("Elevator Encoder Counts per Rev", stretchRightEnc.getCountsPerRevolution());
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
        lobterStretchLeft.set(Constants.lobterStretchMaxVal*controller.getRawAxis(Constants.manualElevatorAxis));
        lobterStretchRight.set(Constants.lobterStretchMaxVal*controller.getRawAxis(Constants.manualElevatorAxis));
    }
}
