package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class SetTiltCommand extends CommandBase{

    private final TiltSubsystem m_tiltSubsystem;
    private final String m_direction;
    
    public SetTiltCommand(TiltSubsystem tiltSubystem, String direction){
        m_tiltSubsystem = tiltSubystem;
        m_direction = direction;
        addRequirements(m_tiltSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        if(m_direction == "up"){
            m_tiltSubsystem.tiltUp();
        }
        if(m_direction == "down"){
            m_tiltSubsystem.tiltDown();;
        }
        if(m_direction == "home"){
            m_tiltSubsystem.tiltHome();
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
