package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LobterRunSubsystem;
import frc.robot.subsystems.ClawCloseSubsystem;

public class SetLobterSpitCommand extends CommandBase{

    private final LobterRunSubsystem m_lobterRunSubsystem;
    private final ClawCloseSubsystem m_lobterStretchSubsystem;
    
    public SetLobterSpitCommand(LobterRunSubsystem lobterRunSubsystem, ClawCloseSubsystem lobterStretchSubsystem){
        m_lobterRunSubsystem = lobterRunSubsystem;
        m_lobterStretchSubsystem = lobterStretchSubsystem;
        addRequirements(m_lobterRunSubsystem);
        addRequirements(m_lobterStretchSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_lobterRunSubsystem.spit();
        m_lobterStretchSubsystem.drop();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
