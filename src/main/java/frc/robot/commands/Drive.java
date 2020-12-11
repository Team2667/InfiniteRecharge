package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Drive extends CommandBase {
    private DriveTrain driveTrain;
    private XboxController jstick;

    public Drive(DriveTrain dt, XboxController joy) {
        driveTrain = dt;
        jstick = joy;
        this.setSubsystem("DriveTrain");
        this.addRequirements(dt);
    }
    public void execute() {
        if (jstick.getTriggerAxis(Hand.kLeft) == 0 ) {
        driveTrain.arcadeDrive(jstick);
        }
        else {
            driveTrain.DriveAtPercentageVelocity(jstick.getTriggerAxis(Hand.kLeft));
        }
    }
    public void end(boolean interupted) {
        driveTrain.stop();
    }
}