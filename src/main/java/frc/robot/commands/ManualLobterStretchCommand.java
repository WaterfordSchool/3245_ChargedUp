package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LobterStretchSubsystem;

public class ManualLobterStretchCommand extends CommandBase{

    private final LobterStretchSubsystem m_lobterStretchSubsystem;
    private XboxController m_controller;
    
    public ManualLobterStretchCommand(LobterStretchSubsystem lobterStretchSubsystem, XboxController controller){
        m_lobterStretchSubsystem = lobterStretchSubsystem;
        m_controller = controller;
        addRequirements(m_lobterStretchSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        if(m_controller.getRawButton(Constants.currentSlideButton)){
            m_lobterStretchSubsystem.currentOutputMode();
        }
        if(!m_controller.getRawButton(Constants.currentSlideButton)){
            m_lobterStretchSubsystem.moveManual(m_controller);
        }

        //maybe combine encoder command with this class? avoid logic loops
        //if the axis value = 0, then if this button is pressed set to this command (inception)
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
        //return (!m_controller.getRawButton(Constants.currentSlideButton));
    }

}
