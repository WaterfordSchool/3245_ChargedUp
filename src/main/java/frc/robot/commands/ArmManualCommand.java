package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubystem;

public class ArmManualCommand extends CommandBase{

    private final ArmSubystem m_armSubsystem;
    private XboxController m_controller;
    
    public ArmManualCommand(ArmSubystem armSubystem, XboxController controller){
        m_armSubsystem = armSubystem;
        m_controller = controller;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {}
        
    @Override
    public void execute() {
        m_armSubsystem.moveArmManually(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
