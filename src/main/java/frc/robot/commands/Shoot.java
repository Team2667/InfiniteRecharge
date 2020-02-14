package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
    private Shooter shooter;
    
    public Shoot(Shooter shooter) {
        this.shooter = shooter;
        this.setSubsystem("Shoot");
        addRequirements(shooter);
    }

    public void execute() {
        shooter.start(-0.75);
    }

    public void end(boolean isInterupted) {
        shooter.stop();
    }
}
