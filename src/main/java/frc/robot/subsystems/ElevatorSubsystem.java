package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ElevatorSubsystem extends SubsystemBase{
    public final CANSparkMax elevator;
    public final SparkMaxPIDController elevatorPID;
    private final RelativeEncoder elevatorEnc;
    /*TODO
     * attach encoder
     * tune encoder, check polarity
     * tune PID
     * think about motion magic?
     */
    //motors

    //init stuff
    public ElevatorSubsystem(){
        elevator = new CANSparkMax(Constants.elevatorMotorID, MotorType.kBrushless);
        elevatorEnc = elevator.getEncoder();
        elevatorPID = elevator.getPIDController();
        //config PID
        elevatorPID.setFF(Constants.elevatorkF);
        elevatorPID.setP(Constants.elevatorkP);
        elevatorPID.setI(Constants.elevatorkI);
        elevatorPID.setD(Constants.elevatorkD);
        
        //set max voltage motor limit
        elevator.setClosedLoopRampRate(Constants.elevatorClosedRampRate);
        elevatorPID.setOutputRange(-Constants.elevatorClosedMaxVal, Constants.elevatorClosedMaxVal);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Encoder Position", elevatorEnc.getPosition());
        SmartDashboard.putNumber("Elevator Encoder Position Conversion Factor", elevatorEnc.getPositionConversionFactor());
        SmartDashboard.putNumber("Elevator Velocity", elevatorEnc.getVelocity());
        SmartDashboard.putNumber("Elevator Encoder Counts per Rev", elevatorEnc.getCountsPerRevolution());
    }
    
    public void resetElevatorEncoder(){
        //set encoder value to 0
        elevatorEnc.setPosition(0);
    }

    public void moveDownElevator(){
        //set elevator to down encoder position
    }

    public void moveUpElevator(){
        //set elevator to up encoder position
    }

    public void moveManual(XboxController controller){
        //move elevator manually
        elevator.set(0.4*controller.getRawAxis(Constants.manualElevatorAxis));
    }

}
