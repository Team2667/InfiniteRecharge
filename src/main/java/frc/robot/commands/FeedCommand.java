package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeedCommand extends CommandBase {
    public Feeder feedMotor;
    public FeedCommand(Feeder feedMotor) {
        this.feedMotor = feedMotor;
        this.addRequirements(feedMotor);
    }

    @Override
    public void execute() {
        feedMotor.feederStart(.5);
    }

    @Override
    public void end(boolean interupted) {
        feedMotor.feederStop();
    }
}