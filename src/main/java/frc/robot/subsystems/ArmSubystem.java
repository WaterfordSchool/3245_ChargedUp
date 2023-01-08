package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubystem extends SubsystemBase{
    //motors

    //init stuff
    public ArmSubystem(){}

    @Override
    public void periodic() {
        //make arm motor
        //config encoder
        //config PID
        //config sensor phase
        //set max voltage motor limit
    }
    
    public void resetArmEncoder(){
        //reset arm encoder (use in loading, low position)
    }

    public void moveLow(){
        //set arm to low encoder position
    }

    public void moveMid(){
        //setarm to mid encoder position
    }

    public void moveHigh(){
        //set arm to high encoder position
    }
    public void moveBack(){
        //set arm to 0 encoder position
    }

}
