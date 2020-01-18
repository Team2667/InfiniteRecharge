/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ColorComm;
import frc.robot.commands.Drive;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private XboxController joy;
  private DriveTrain m_driveTrain;
  private Shooter m_shooter;
  private ColorWheel m_cWheel;
  private Shoot m_shootCmd;
  private Drive m_driveCmd;
  private ColorComm m_colorCommand;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    joy = new XboxController(0);
  
    setupDriveTrain();
    setupShooter();
    setupColorWheel();
  }

  private void setupDriveTrain() {
    m_driveTrain = new DriveTrain();
    m_driveCmd = new Drive(m_driveTrain, joy);
    m_driveTrain.setDefaultCommand(m_driveCmd);
  }
  
  private void setupShooter() {
    m_shooter = new Shooter();
    m_shootCmd = new Shoot(m_shooter);
    JoystickButton b = new JoystickButton(joy, XboxController.Button.kBumperLeft.value);
    b.whileHeld(m_shootCmd);
  }

  private void setupColorWheel() {
    m_cWheel = new  ColorWheel();
    m_colorCommand = new ColorComm(m_cWheel);
    JoystickButton a = new JoystickButton(joy, XboxController.Button.kA.value);
    a.whileHeld(m_colorCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
