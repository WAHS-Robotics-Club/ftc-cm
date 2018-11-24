package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.reflect.Modifier;

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

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        final double DIAMETER = 4;
        final int ENCODER_SINGLE_ROTATION = 1120;

        double distance = 24;
        int MOVEMENT = (int) ((distance / DIAMETER) * Math.PI) * ENCODER_SINGLE_ROTATION;

        waitForStart();

        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FrontRight.setTargetPosition(MOVEMENT);
        BackLeft.setTargetPosition(MOVEMENT);
        BackRight.setTargetPosition(MOVEMENT);



        while(FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy()) {
            Thread.sleep(1);
        }

    }
}