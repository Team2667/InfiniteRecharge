package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class ColorComm extends CommandBase {
    public ColorWheel sensorMotor;
    public ColorComm(ColorWheel sensorMotor) {
        this.sensorMotor = sensorMotor;
        this.addRequirements(sensorMotor);
    }

    @Override
    public void execute() {
        sensorMotor.wheelStart(0.5);
    }

    @Override
    public void end(boolean interupted) {
        sensorMotor.wheelStop();
    }
}