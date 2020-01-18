package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRotary;

public class Intake extends CommandBase {
    public IntakeRotary intakeMotor;
    public Intake(IntakeRotary intakeMotor) {
        this.intakeMotor = intakeMotor;
        this.addRequirements(intakeMotor);
    }

    @Override
    public void execute() {
        intakeMotor.rotaryStart(0.5);
    }

    @Override
    public void end(boolean interupted) {
        intakeMotor.rotaryStop();
    }
}