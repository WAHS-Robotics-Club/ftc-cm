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

    DcMotor fr, fl, br, bl, spinny, tnado;
    CRServo o;
    Servo p;
    Object x, y, z;

    @Override
    public void init() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");
        spinny = hardwareMap.dcMotor.get("spinny");
        tnado = hardwareMap.dcMotor.get("tnado");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinny.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


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

        if (gamepad2.right_bumper = true) {
            spinny.setPower(-1);
        }else {
            spinny.setPower(0);
        }
        if (gamepad2.left_bumper = true) {
            spinny.setPower(1);
        }else {
            spinny.setPower(0);
        }

        if (gamepad1.dpad_up = true) {
            tnado.setPower(-.6);
        }else {
            tnado.setPower(0);
        }
        if (gamepad1.dpad_down = true) {
            tnado.setPower(.4);
        }else {
            tnado.setPower(0);
        }
    }
}
