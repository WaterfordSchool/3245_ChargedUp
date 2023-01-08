package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
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
        
        //set max voltage motor limit
        elevator.setClosedLoopRampRate(0.2);
    }

    @Override
    public void periodic() {}
    
    public void resetElevatorEncoder(){
        //set encoder value to 0
    }

    public void moveDownElevator(){
        //set elevator to down encoder position
    }

    public void moveUpElevator(){
        //set elevator to up encoder position
    }

    public void moveElevatorManual(XboxController controller){
        //move elevator manually
        elevator.set(0.4*controller.getRawAxis(Constants.manualElevatorAxis));
    }

}
