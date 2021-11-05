package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Branch: dan_code

@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Local DcMotor variables:
    //Creates the code objects for the motors
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;

    //Initiation process:
    @Override
    public void init(){
        //Hardwaremaps ALL motors:
        //This connects the motor objects to the hardware map on the phone
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
    }

    //Loop process:
    @Override
    public void loop(){
        //the format "motor name" (set up above) .setPower(); sets the motor speed, the range of inputs is from 0 (not moving) to 1 (full speed)
        frontLeftMotor.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y);
        backLeftMotor.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y);
        frontRightMotor.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y);
        backRightMotor.setPower(gamepad1.left_stick_x + -gamepad1.left_stick_y);
    }
}