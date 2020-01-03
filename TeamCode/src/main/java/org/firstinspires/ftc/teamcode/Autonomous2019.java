package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@Autonomous (name = "Main2019")
@Disabled
public class Autonomous2019 extends LinearOpMode{

    DcMotor fl, fr, bl, br;


    @Override
    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        final double DIAMETER = 4;
        final int ENCODER_SINGLE_ROTATION = 1120;

        double distance = 24;
        int MOVEMENT = (int) (distance / (DIAMETER * Math.PI)) * ENCODER_SINGLE_ROTATION;

        double DiagDist = 33.25;
        int DIAGONAL = (int) (DiagDist / (DIAMETER * Math.PI)) * ENCODER_SINGLE_ROTATION;

        waitForStart();

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fl.setTargetPosition(-DIAGONAL);
        fr.setTargetPosition(DIAGONAL);
        bl.setTargetPosition(-DIAGONAL);
        br.setTargetPosition(DIAGONAL);

        fl.setPower(.6);
        fr.setPower(.6);
        bl.setPower(.6);
        br.setPower(.6);

        while (fl.isBusy() || fr.isBusy() || bl.isBusy() || br.isBusy()) {
            telemetry.addData("FL", fl.getCurrentPosition());
            telemetry.addData("FR", fr.getCurrentPosition());
            telemetry.addData("BL", bl.getCurrentPosition());
            telemetry.addData("BR", br.getCurrentPosition());
            telemetry.update();
            Thread.sleep(1);
        }

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);

        Thread.sleep(500);

        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    

}
