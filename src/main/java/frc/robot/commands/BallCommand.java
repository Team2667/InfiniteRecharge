package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallFeed;

public class BallCommand extends CommandBase {
    public BallFeed ballMotor;
    public BallCommand(BallFeed ballMotor) {
        this.ballMotor = ballMotor;
        this.addRequirements(ballMotor);
    }

    @Override
    public void execute() {
        ballMotor.ballStart(.5);
    }

    @Override
    public void end(boolean interupted) {
        ballMotor.ballStop();
    }
}