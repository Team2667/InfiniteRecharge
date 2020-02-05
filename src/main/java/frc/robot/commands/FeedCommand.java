package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRotary;

public class FeedCommand extends CommandBase {
    public IntakeRotary feedMotor;
    public FeedCommand(IntakeRotary feedMotor) {
        this.feedMotor = feedMotor;
        this.addRequirements(feedMotor);
    }

    @Override
    public void execute() {
        feedMotor.rotaryStart(.5);
    }

    @Override
    public void end(boolean interupted) {
        feedMotor.rotaryStop();
    }
}