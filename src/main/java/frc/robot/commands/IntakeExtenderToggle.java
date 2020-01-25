package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeExtender;

public class IntakeExtenderToggle extends CommandBase {
    private IntakeExtender intakeExtender;
    public IntakeExtenderToggle(IntakeExtender intakeExtender) {
        this.intakeExtender = intakeExtender;
        this.addRequirements(intakeExtender); 
    }

    @Override
    public void initialize() {
        intakeExtender.toggleIntake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

