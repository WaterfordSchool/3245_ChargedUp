package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LobterRunSubsystem;

public class SetLobterSpitCommand extends CommandBase{

    private final LobterRunSubsystem m_lobterRunSubsystem;
    
    public SetLobterSpitCommand(LobterRunSubsystem lobterRunSubsystem){
        m_lobterRunSubsystem = lobterRunSubsystem;
        addRequirements(m_lobterRunSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_lobterRunSubsystem.spit();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
