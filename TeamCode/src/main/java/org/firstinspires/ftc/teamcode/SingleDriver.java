package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Branch: dan_code

@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Local DcMotor variables:
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;

    //Initiation process:
    @Override
    public void init(){
        //Hardwaremap ALL motors:
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
    }

    //Loop process:
    @Override
    public void loop(){
        frontLeftMotor.setPower(-gamepad1.left_stick_y);
        backLeftMotor.setPower(-gamepad1.left_stick_y);
        frontRightMotor.setPower(gamepad1.left_stick_y);
        backRightMotor.setPower(gamepad1.left_stick_y);
    }
}