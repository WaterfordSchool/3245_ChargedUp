package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ElevatorSubsystem extends SubsystemBase{
    //falcon
    public final TalonFX elevatorMaster;
    public final TalonFXSensorCollection elevatorMasterEnc;
    public final TalonFX elevatorSlave;
    public final TalonFXSensorCollection elevatorSlaveEnc;
   /*public final CANSparkMax elevator;
    public final SparkMaxPIDController elevatorPID;
    private final RelativeEncoder elevatorEnc;*/
    /*TODO
     * attach encoder
     * tune encoder, check polarity
     * tune PID
     * think about motion magic?
     */
    //motors

    //init stuff
    public ElevatorSubsystem(){
        elevatorMaster = new TalonFX(Constants.elevatorMotorMasterID);
        elevatorMasterEnc = elevatorMaster.getSensorCollection();
        elevatorSlave = new TalonFX(Constants.elevatorMotorSlaveID);
        elevatorSlaveEnc = elevatorSlave.getSensorCollection();
        //config PID
        elevatorMaster.config_kF(0, Constants.elevatorkF);
        elevatorMaster.config_kP(0, Constants.elevatorkF);
        elevatorMaster.config_kI(0, Constants.elevatorkF);
        elevatorMaster.config_kD(0, Constants.elevatorkF);

        
        //set max voltage motor limit
        elevatorMaster.configClosedloopRamp(Constants.elevatorClosedRampRate);
        elevatorMaster.configClosedLoopPeakOutput(0, Constants.elevatorClosedMaxVal);
        elevatorSlave.follow(elevatorMaster);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Encoder Absolute Position", elevatorMasterEnc.getIntegratedSensorAbsolutePosition());
        SmartDashboard.putNumber("Elevator Encoder Relative Position", elevatorMasterEnc.getIntegratedSensorPosition());
    }
    
    public void resetElevatorEncoder(){
        //set encoder value to 0
        elevatorMasterEnc.setIntegratedSensorPosition(0, 15);
    }

    public void moveDownElevator(){
        //set elevator to down encoder position
        elevatorMaster.set(ControlMode.Position, Constants.elevatorDownPos);
    }

    public void moveUpElevator(){
        //set elevator to up encoder position
        elevatorMaster.set(ControlMode.Position, Constants.elevatorUpPos);
    }

    public void moveManual(XboxController controller){
        //move elevator manually
        elevatorMaster.set(ControlMode.PercentOutput, 0.4*controller.getRawAxis(Constants.manualElevatorAxis));
    }

}
