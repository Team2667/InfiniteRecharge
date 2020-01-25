package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRotary;

public class IntakeRotaryToggle extends CommandBase {
    private IntakeRotary intakeRotary;
    public IntakeRotaryToggle(IntakeRotary intakeRotary) {
        this.intakeRotary = intakeRotary;
        this.addRequirements(intakeRotary); 
    }

    @Override
    public void initialize() {
        intakeRotary.rotaryToggle(.5);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}