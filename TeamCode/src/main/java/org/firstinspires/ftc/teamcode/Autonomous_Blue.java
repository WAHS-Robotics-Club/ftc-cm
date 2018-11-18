package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous (name = "AutonomousBlue")
public class Autonomous_Blue extends LinearOpMode {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight, Lift, Ramp, Claw;

   // CRServo ;


    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeft = hardwareMap.dcMotor.get("fl");
        FrontRight = hardwareMap.dcMotor.get("fr");
        BackLeft = hardwareMap.dcMotor.get("bl");
        BackRight = hardwareMap.dcMotor.get("br");
        Ramp = hardwareMap.dcMotor.get("ramp");
        Lift = hardwareMap.dcMotor.get("lift");
        Claw = hardwareMap.dcMotor.get("claw");

        waitForStart();



        FrontLeft.setPower(-1);
        FrontRight.setPower(1);
        BackLeft.setPower(-1);
        BackRight.setPower(1);

        wait(1000);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}