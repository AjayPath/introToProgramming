package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.intakeConstants;
import frc.robot.subsystems.intakeSubsystem;

public class intakeCmd extends Command{
    
    // Create a new intake subsystem object
    private intakeSubsystem intakeSubsystem;

    // New variable to control the velocity
    private double intakeVelocity;

    /* CREATE THE NEW INTAKE COMMAND */
    public intakeCmd(intakeSubsystem intakeSubsystem, double intakeVelocity) {
        this.intakeSubsystem = intakeSubsystem;
        this.intakeVelocity = intakeVelocity;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(intakeSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
        // Usually you want to put setup code here for the motor
        intakeSubsystem.setIntakeVelocityMode();
        intakeSubsystem.setRampRate(intakeConstants.intakeRampRate);
        intakeSubsystem.setIntakePIDF(intakeConstants.intakeKp, intakeConstants.intakeKi, intakeConstants.intakeKd, intakeConstants.intakeKFf);
        intakeSubsystem.setIntakeEncoderOutputConstraints(intakeConstants.intakeMin, intakeConstants.intakeMax);

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intakeSubsystem.setVelocityIntake((intakeVelocity * 3)); 
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setCoastMode();
        intakeSubsystem.setVelocityIntake(0);
    }

}
