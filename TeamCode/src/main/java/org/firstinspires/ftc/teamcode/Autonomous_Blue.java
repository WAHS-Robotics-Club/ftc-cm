package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "Autonomous Marker")
public class Autonomous_Blue extends LinearOpMode {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight;// Ramp, Claw;

//    CRServo Lift;


    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeft = hardwareMap.dcMotor.get("fl");
        FrontRight = hardwareMap.dcMotor.get("fr");
        BackLeft = hardwareMap.dcMotor.get("bl");
        BackRight = hardwareMap.dcMotor.get("br");
//        Ramp = hardwareMap.dcMotor.get("ramp");
//        Claw = hardwareMap.dcMotor.get("claw");

//        Lift = hardwareMap.crservo.get("lift");

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

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

//        FrontLeft.setTargetPosition(3 * -DIAGONAL);
//        FrontRight.setTargetPosition(3 * DIAGONAL);
//        BackLeft.setTargetPosition(3 * -DIAGONAL);
//        BackRight.setTargetPosition(3 * DIAGONAL);

        FrontLeft.setPower(-1);
        FrontRight.setPower(1);
        BackLeft.setPower(-1);
        BackRight.setPower(1);

        Thread.sleep(2000);

//        while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy()) {
//            Thread.sleep(1);
//        }

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

        Thread.sleep(500);

        FrontLeft.setPower(1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(1);

        Thread.sleep(400);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

    }
}