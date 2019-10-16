package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous (name = "Autonomous Crater")
@Disabled
public class Autonomous_2 extends LinearOpMode {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight; //Ramp, Claw;

//    CRServo Lift;


    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeft = hardwareMap.dcMotor.get("fl");
        FrontRight = hardwareMap.dcMotor.get("fr");
        BackLeft = hardwareMap.dcMotor.get("bl");
        BackRight = hardwareMap.dcMotor.get("br");
     //   Ramp = hardwareMap.dcMotor.get("ramp");
     //   Claw = hardwareMap.dcMotor.get("claw");

     //   Lift = hardwareMap.crservo.get("lift");

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        final double DIAMETER = 4;
        final int ENCODER_SINGLE_ROTATION = 1120;

        double distance = 24;
        int MOVEMENT = (int) (distance / (DIAMETER * Math.PI)) * ENCODER_SINGLE_ROTATION;

        double DiagDist = 33.25;
        int DIAGONAL = (int) (DiagDist / (DIAMETER * Math.PI)) * ENCODER_SINGLE_ROTATION;

        waitForStart();

        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FrontLeft.setTargetPosition(-DIAGONAL);
        FrontRight.setTargetPosition(DIAGONAL);
        BackLeft.setTargetPosition(-DIAGONAL);
        BackRight.setTargetPosition(DIAGONAL);

        FrontLeft.setPower(.6);
        FrontRight.setPower(.6);
        BackLeft.setPower(.6);
        BackRight.setPower(.6);

        while (FrontLeft.isBusy() || FrontRight.isBusy() || BackLeft.isBusy() || BackRight.isBusy()) {
            telemetry.addData("FL", FrontLeft.getCurrentPosition());
            telemetry.addData("FR", FrontRight.getCurrentPosition());
            telemetry.addData("BL", BackLeft.getCurrentPosition());
            telemetry.addData("BR", BackRight.getCurrentPosition());
            telemetry.update();
            Thread.sleep(1);
        }

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

        Thread.sleep(500);

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        FrontLeft.setPower(.7);
        FrontRight.setPower(.7);
        BackLeft.setPower(.7);
        BackRight.setPower(.7);

        Thread.sleep(666);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

        Thread.sleep(600);
    }
}