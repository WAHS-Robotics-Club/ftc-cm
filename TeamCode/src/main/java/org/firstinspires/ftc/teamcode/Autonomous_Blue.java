package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous (name = "AutonomousBlue")
public class Autonomous_Blue extends LinearOpMode {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight, PowerLift, Ramp;

    CRServo Claw;


    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        Ramp = hardwareMap.dcMotor.get("Ramp");

        Claw = hardwareMap.crservo.get("Claw");

        waitForStart();



        FrontLeft.setPower(1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(1);

        wait(1000);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}