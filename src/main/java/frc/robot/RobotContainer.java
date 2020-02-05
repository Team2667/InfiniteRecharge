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
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeExtender;
import frc.robot.commands.IntakeExtenderToggle;
import frc.robot.subsystems.IntakeRotary;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
  private IntakeRotary m_rotary;
  private FeedCommand m_rotaryCommand;
  private IntakeReverse m_rotaryReverseCommand;
  private IntakeExtender m_intakeExtender;
  private IntakeExtenderToggle m_IntakeExtenderCommand; 
  private IntakeRotary m_IntakeRotary;
  private IntakeRotaryToggle m_IntakeRotaryToggle;
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
  
    // setupDriveTrain();
    // setupShooter();
   setupColorWheel();
   setupIntakeExtender();

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
    m_colorCommand = new SequentialCommandGroup(new CallibrateColorWheel(m_cWheel), new CountRevolutions(m_cWheel));
    JoystickButton a = new JoystickButton(joy, XboxController.Button.kA.value);
    a.whenPressed(m_colorCommand);
  }


  private void setupIntakeExtender() {
    m_intakeExtender = new IntakeExtender();
    m_IntakeExtenderCommand = new IntakeExtenderToggle(m_intakeExtender);
    m_IntakeRotary = new IntakeRotary();
    m_IntakeRotaryToggle = new IntakeRotaryToggle(m_IntakeRotary);
    var commandGrp = new ParallelCommandGroup(m_IntakeRotaryToggle,m_IntakeExtenderCommand);
    JoystickButton y = new JoystickButton(joy, XboxController.Button.kY.value);
    y.whenPressed(commandGrp);
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
