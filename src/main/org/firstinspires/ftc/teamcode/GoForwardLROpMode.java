package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.OpMode;
import com.qualcomm.robotcore.eventloop.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Objective:
// Use Gamepad's left stick to drive Robot's left front wheel and use right stick to drive Robot's right front wheel
// Let rear wheels follow freely

@TeleOp
//Name of the class must be same as filename
public class GoForwardLROpMode extends OpMode {

  // Declare all the motor variables
  private DcMotor lfMotor; //Left Front
  private DcMotor lrMotor; //Left Rear
  private DcMotor rfMotor; //Right Front
  private DcMotor rrMotor; //Right Rear
  
  @Override
  public void init() {
    // Following code will execute when the Driver presses 'INIT' button on the Driver Station for this OpMode
    
    // initialize motors here with proper names configured in the settings
    lfMotor = hardwareMap.dcMotor.get("");
    lrMotor = hardwareMap.dcMotor.get("");
    rfMotor = hardwareMap.dcMotor.get("");
    rrMotor = hardwareMap.dcMotor.get("");
    
    // Let's only front wheels do the driving and let rear wheels follow freely
    lrMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    rrMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    
    // Apply brakes on front wheels when there is no power
    lfMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rfMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
  }
  
  @Override
  public void loop() {
    // Following code will execute repeatedly after the Driver presses 'Play' button on the Driver Station for this OpMode
    
    // We will use Gamepad's left stick's y co-ordinate to control the front wheels to move forward.
    // When the Driver presses the left stick forward, it actually generates a negative number between 0 and -1 in y co-ordinate
    int lyPower = (-1) * gamepad1.left_stick_y;
    int ryPower = (-1) * gamepad1.right_stick_y;
    
    // Now we assign this power to the respective front wheels
    lfMotor.setPower(lyPower);
    rfMotor.setPower(ryPower);
  }
  
  // And that's it! Now, compile/build and send this program to the Robot and test!
}
