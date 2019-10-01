package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Hmm")
public class TestOp extends OpMode {
    DcMotor fr, fl, br, bl;

    @Override
    public void init() {
        fr = hardwareMap.dcMotor.get("fr");
        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        bl = hardwareMap.dcMotor.get("bl");

        //sl = hardwareMap.servo.get("sl");
        //sr = hardwareMap.servo.get("sr");

        //sl.setPosition(.18);

        }

    @Override
    public void loop() {

        float yl = gamepad1.left_stick_y;
        float yr = gamepad1.right_stick_y;

        if (Math.abs(gamepad1.left_stick_y) > .01){
            fl.setPower(yl);
            bl.setPower(yl);

        } else {
           fl.setPower(0);
           bl.setPower(0);
            fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }
        if (Math.abs(gamepad1.right_stick_y) > .01) {
            fr.setPower(-yr);
            br.setPower(-yr);

        } else {
            fr.setPower(0);
            br.setPower(0);
            fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }


    }
}
