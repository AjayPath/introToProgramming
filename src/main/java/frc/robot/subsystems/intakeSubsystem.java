package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Imports needed to run velocity control for a REV Neo
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

// Intake Constants
import frc.robot.Constants.intakeConstants;
import frc.robot.subsystems.intakeSubsystem;

public class intakeSubsystem extends SubsystemBase{
    
    /* INITIAL SETUP */

    // First we want to create objects for our motor and encoder
    private CANSparkMax intakeMotor = new CANSparkMax(intakeConstants.intakeMotorCANId, MotorType.kBrushless);
    
    // You can see we are accessing the object intakeMotor which is from the SparkMax class
    private RelativeEncoder intakeRelativeEncoder = intakeMotor.getEncoder();   

    /* CREATE A NEW INTAKE SUBSYTEM */
    public intakeSubsystem() {
        intakeMotor.restoreFactoryDefaults();    // restore motor settings to factory defult
        intakeMotor.setSmartCurrentLimit(20);    // Set the current limit of the motor
        intakeMotor.setInverted(false);    // Set motor to not inverted
        intakeRelativeEncoder.setPosition(0);    // Set encoder position to zero
        intakeMotor.burnFlash();   // Burn and flash the new settings to the motor controller
    }

    /* Periodic Part of the subsystem (runs constantly) */
    @Override
    public void periodic() {

    }

    /* THE FOLLOWING SECTION IS USED FOR USEFUL GENERIC FUNCTIONS AND SETUP FUNCTIONS */

    /* SETUP PIDF OF THE MOTOR */
    public void setIntakePIDF(double p, double i, double d, double f){
        intakeMotor.getPIDController().setP(p); 
        intakeMotor.getPIDController().setI(i); 
        intakeMotor.getPIDController().setD(d); 
        intakeMotor.getPIDController().setFF(f); 
    }

    public void setIntakeEncoderOutputConstraints(double min, double max){
        intakeMotor.getPIDController().setOutputRange(min, max); 
    }

    public void setRampRate(double ramp){
        intakeMotor.setClosedLoopRampRate(ramp);
    }
    
    /* SET THE MOTOR TO BE IN VELOCITY MODE */
    public void setIntakeVelocityMode(){
        intakeMotor.getPIDController().setReference(0, ControlType.kVelocity); 
    }

    /* BRAKE AND COAST FUNCTIONS */

    // Motor stops in the instant
    public void setBrakeMode(){
        intakeMotor.setIdleMode(IdleMode.kBrake); 
    }
    
    // Motor comes to a rolling stop
    public void setCoastMode(){
        intakeMotor.setIdleMode(IdleMode.kCoast); 
    }
    
    /* GENERIC ENCODER FUNCTIONS */
    
    public void resetEncoders(){
        intakeRelativeEncoder.setPosition(0);  
    }
    
    public double getintake_encoderPosition(){
        return intakeRelativeEncoder.getPosition(); 
    }
    
    public double getintake_encoderVelocity(){
        return intakeRelativeEncoder.getVelocity();     
    }

    /* GENERIC INTAKE FUNCTIONS */

    // Set the velocity of the intake motor
    public void setVelocityIntake(double intakeVelocity){
        intakeMotor.getPIDController().setReference(intakeVelocity, ControlType.kVelocity); 
    }

    // Stop the intake motor
    public void stop(){
        intakeMotor.stopMotor();
    }
}
