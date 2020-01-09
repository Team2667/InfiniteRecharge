package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID;

public class Drive extends CommandBase {
    private DriveTrain driveTrain;
    private GenericHID jstick;

    public Drive(DriveTrain dt, GenericHID joy) {
        driveTrain = dt;
        jstick = joy;
        this.setSubsystem("DriveTrain");
    }
    public void execute() {
        driveTrain.arcadeDrive(jstick);
    }
}