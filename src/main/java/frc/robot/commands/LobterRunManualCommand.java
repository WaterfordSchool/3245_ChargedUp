package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LobterRunSubsystem;

public class LobterRunManualCommand extends CommandBase{

    private final LobterRunSubsystem m_lobterSubsystem;
    private XboxController m_controller;
    
    public LobterRunManualCommand(LobterRunSubsystem lobterSubsystem, XboxController controller){
        m_lobterSubsystem = lobterSubsystem;
        m_controller = controller;
        addRequirements(m_lobterSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_lobterSubsystem.manualSpin(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }

}
