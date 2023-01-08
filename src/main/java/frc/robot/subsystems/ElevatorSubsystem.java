package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    /*TODO
     * attach(?) encoder
     * tune encoder, check polarity
     * tune PID
     * think about motion magic?
     */
    //motors

    //init stuff
    public ElevatorSubsystem(){
        //make elevator motor
        //config encoder
        //config PID
        //config sensor phase
        //set max voltage motor limit
        //lots of ramping like LOTS of ramping
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

    public void moveElevatorManual(){
        //move elevator manually
    }

}
