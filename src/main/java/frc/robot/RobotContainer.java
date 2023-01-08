// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmManualCommand;
import frc.robot.commands.ElevatorManualCommand;
import frc.robot.commands.SetArmCommand;
import frc.robot.subsystems.ArmSubystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  XboxController driver = new XboxController(0);
  XboxController operator = new XboxController(1);

  //subsystems
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final ArmSubystem m_armSubsystem = new ArmSubystem();
  private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  //commands
  //drive commands
  private final ArcadeDrive m_fastDrive = new ArcadeDrive(m_driveTrain, 1, driver);
  private final ArcadeDrive m_slowDrive = new ArcadeDrive(m_driveTrain, 0.3, driver);
  private final ArcadeDrive m_arcadeDefault = new ArcadeDrive(m_driveTrain, 0.8, driver);

  //arm commands
  private final ArmManualCommand m_armManualCommand = new ArmManualCommand(m_armSubsystem, operator);
  
  //elevator commands
  private final ElevatorManualCommand m_elevatorManualCommand = new ElevatorManualCommand(m_elevatorSubsystem, operator);

  public RobotContainer() {
    m_driveTrain.setDefaultCommand(m_arcadeDefault);
    m_armSubsystem.setDefaultCommand(m_armManualCommand);
    m_elevatorSubsystem.setDefaultCommand(m_elevatorManualCommand);
    configureButtonBindings();
  }

  
  private void configureButtonBindings() {
    JoystickButton fastButton = new JoystickButton(driver, Constants.fastButton);
    JoystickButton slowButton = new JoystickButton(driver, Constants.slowButton);

    fastButton.whenPressed(m_fastDrive);
    slowButton.whenPressed(m_slowDrive);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
