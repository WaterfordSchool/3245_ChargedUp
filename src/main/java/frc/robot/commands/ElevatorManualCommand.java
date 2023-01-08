package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorManualCommand extends CommandBase{

    private final ElevatorSubsystem m_elevatorSubsystem;
    private XboxController m_controller;
    
    public ElevatorManualCommand(ElevatorSubsystem elevatorSubsystem, XboxController controller){
        m_elevatorSubsystem = elevatorSubsystem;
        m_controller = controller;
        addRequirements(m_elevatorSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_elevatorSubsystem.moveElevatorManual(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}