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
import frc.robot.commands.FeedCommand;
import frc.robot.commands.IntakeReverse;
import frc.robot.commands.IntakeRotaryToggle;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.BallFeed;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeExtender;
import frc.robot.subsystems.Feeder;
import frc.robot.commands.FeedCommand;
import frc.robot.commands.IntakeExtenderToggle;
import frc.robot.subsystems.IntakeRotary;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BallCommand;
import frc.robot.commands.CallibrateColorWheel;
import frc.robot.commands.ColorComm;
import frc.robot.commands.CountRevolutions;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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
  private Command m_colorCommand;
  private IntakeExtender m_intakeExtender;
  private IntakeExtenderToggle m_IntakeExtenderCommand; 
  private IntakeRotary m_IntakeRotary;
  private IntakeRotaryToggle m_IntakeRotaryToggle;
  private Feeder m_Feeder;
  private FeedCommand m_FeedCommand;
  private BallFeed m_BallFeed;
  private BallCommand m_BallCommand;
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
   // setupColorWheel();
   setupIntakeExtender();
   setupIntakeRotary();
   setupBallCommand();
   setupFeederCommand();
   mapButtons();

  }

  private void mapButtons() {
    mapFeedeerButton();
    mapShooterButton();
    mapIntakeButton();
  }

  private void mapFeedeerButton() {
    if(m_FeedCommand != null && m_BallCommand != null) {
      JoystickButton bR = new JoystickButton(joy, XboxController.Button.kBumperRight.value);
      bR.whileHeld(new ParallelCommandGroup(m_FeedCommand, m_BallCommand));
    }
  }

/*
  private void mapTemplate() {
    if(m_command != null) {
      JoystickButton (Button Name) = new JoystickButton(joy, XboxController.Button.(Button Name).value);
      (Button Name).whenPressed(m_command);
    }
  }
*/

private void mapIntakeButton() {
  if(m_IntakeExtenderCommand != null && m_IntakeRotaryToggle != null) {
    JoystickButton x = new JoystickButton(joy, XboxController.Button.kX.value);
    x.whenPressed(new ParallelCommandGroup(m_IntakeExtenderCommand, m_IntakeRotaryToggle));
  }
}

  private void mapShooterButton() {
    if(m_shootCmd != null) {
      JoystickButton bL = new JoystickButton(joy, XboxController.Button.kBumperLeft.value);
      bL.whileHeld(m_shootCmd);
    }
  }

  private void setupDriveTrain() {
    m_driveTrain = new DriveTrain();
    m_driveCmd = new Drive(m_driveTrain, joy);
    m_driveTrain.setDefaultCommand(m_driveCmd);
  }
  
  private void setupShooter() {
    m_shooter = new Shooter();
    m_shootCmd = new Shoot(m_shooter);
  }

  private void setupColorWheel() {
    m_cWheel = new  ColorWheel();
    m_colorCommand = new SequentialCommandGroup(new CallibrateColorWheel(m_cWheel), new CountRevolutions(m_cWheel));
    JoystickButton a = new JoystickButton(joy, XboxController.Button.kA.value);
    a.whenPressed(m_colorCommand);
  }

  private void setupIntakeExtender() {
    m_intakeExtender = new IntakeExtender();
    m_IntakeExtenderCommand = new IntakeExtenderToggle(m_intakeExtender);
  }

  private void setupIntakeRotary() {
    m_IntakeRotary = new IntakeRotary();
    m_IntakeRotaryToggle = new IntakeRotaryToggle(m_IntakeRotary);
  }

  private void setupFeederCommand() {
    m_Feeder = new Feeder();
    m_FeedCommand = new FeedCommand(m_Feeder);
  }

  private void setupBallCommand() {
    m_BallFeed = new BallFeed();
    m_BallCommand = new BallCommand(m_BallFeed);
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
