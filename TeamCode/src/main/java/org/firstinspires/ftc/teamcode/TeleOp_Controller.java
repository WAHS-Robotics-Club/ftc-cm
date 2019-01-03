package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.BrokenBarrierException;

@TeleOp (name = "Player Control")
public class TeleOp_Controller extends OpMode {

    DcMotor fr, fl, br, bl, arm, claw, ramp, scoop;
    CRServo lift, lifty_boi;
    Servo cover1, cover2;
    Object x, y, z;

    @Override
    public void init() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");
        arm = hardwareMap.dcMotor.get("arm");
        lift = hardwareMap.crservo.get("lift");
        claw = hardwareMap.dcMotor.get("claw");
        ramp = hardwareMap.dcMotor.get("ramp");
        scoop = hardwareMap.dcMotor.get("scoop");
        lifty_boi = hardwareMap.crservo.get("lifty boi");
        cover1 = hardwareMap.servo.get("cover1");
        cover2 = hardwareMap.servo.get("cover2");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        claw.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;

        if (Math.abs(gamepad1.left_stick_x) > .1 || Math.abs(gamepad1.left_stick_y) > .1 || Math.abs(gamepad1.right_stick_x) > .1) {
            fl.setPower(-x - y - r);
            fr.setPower(-x + y - r);
            bl.setPower(x - y - r);
            br.setPower(x + y - r);
        }else {
            fl.setPower(0);
            fr.setPower(0);
            bl.setPower(0);
            br.setPower(0);
        }


        if (gamepad2.right_bumper = true){
            arm.setPower(.4);
        }else {
            if (gamepad2.left_bumper = true){
                arm.setPower(.4);
            }
            arm.setPower(0);
        }

        if (Math.abs(gamepad2.right_stick_y) > 0.1){
            lift.setPower(gamepad2.right_stick_y);
        }else {
            lift.setPower(0);
        }

        if (gamepad2.b){
            cover1.setPosition(1);
            cover2.setPosition(1);
        }else{
            cover1.setPosition(0);
            cover1.setPosition(0);
        }

        if (gamepad1.left_trigger > 0.1){
            scoop.setPower(1);
        }else{
            scoop.setPower(0);
        }
        if (gamepad1.right_trigger > 0.1){
            lifty_boi.setPower(1);
        }else{
            lifty_boi.setPower(0);
        }
    }
}
