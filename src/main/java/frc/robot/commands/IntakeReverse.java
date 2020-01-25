package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRotary;

public class IntakeReverse extends CommandBase {
    public IntakeRotary intakeMotor;
    public IntakeReverse(IntakeRotary intakeMotor) {
        this.intakeMotor = intakeMotor;
        this.addRequirements(intakeMotor);
    }

    @Override
    public void execute() {
        intakeMotor.rotaryStart(.5);
    }

    @Override
    public void end(boolean interupted) {
        intakeMotor.rotaryStop();
    }
}