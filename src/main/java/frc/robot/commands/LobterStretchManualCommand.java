package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LobterRunSubsystem;
import frc.robot.subsystems.LobterStretchSubsystem;

public class LobterStretchManualCommand extends CommandBase{

    private final LobterStretchSubsystem m_lobterStretchSubsystem;
    private XboxController m_controller;
    
    public LobterStretchManualCommand(LobterStretchSubsystem lobterStretchSubsystem, XboxController controller){
        m_lobterStretchSubsystem = lobterStretchSubsystem;
        m_controller = controller;
        addRequirements(m_lobterStretchSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_lobterStretchSubsystem.moveManual(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }

}
