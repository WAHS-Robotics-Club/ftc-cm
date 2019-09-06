package org.firstinspires.ftc.teamcode.last_year.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class CraneProject2 extends OpMode {
    DcMotor fl, fr, bl, br;
    CRServo Arm1, Arm2;

    @Override
    public void init() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

        Arm1 =hardwareMap.crservo.get("Arm2");
        Arm2 =hardwareMap.crservo.get("Arm2");

    }

    @Override
    public void loop() {

        if (Math.abs(gamepad1.left_stick_y) > 0.1) {

            fl.setPower(1);
            bl.setPower(1);

        } else {

            fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }



        if (Math.abs(gamepad1.right_stick_y) > 0.1) {
            fr.setPower(1);
            br.setPower(1);

        } else {

            fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }


            if (gamepad1.dpad_up = true) {

            Arm1.setPower(1);
            Arm2.setPower(1);
        }
        if (gamepad1.dpad_down = true) {
            Arm1.setPower(-1);
            Arm2.setPower(-1);
            }
        }

    }

