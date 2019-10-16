package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "Main")
public class how extends OpMode {

    DcMotor fr,fl,br,bl;
    CRServo sr,sl;

    @Override
    public void init() {

        fr = hardwareMap.dcMotor.get("fr");
        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        bl = hardwareMap.dcMotor.get("bl");

 //       sr = hardwareMap.crservo.get("sr");
 //       sl = hardwareMap.crservo.get("sl");




    }

    @Override
    public void loop() {

        float move = gamepad1.left_stick_y;


        if (Math.abs(gamepad1.left_stick_y) > 0.1 ){

            fr.setPower(move);
            fl.setPower(-move);
            br.setPower(-move);
            bl.setPower(move);

        } else {

            fr.setPower(0);
            fl.setPower(0);
            br.setPower(0);
            bl.setPower(0);

            fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }


     /*   if(gamepad1.right_bumper = true){

            sl.setPower(1);
            sr.setPower(1);
        }

        if (gamepad1.right_bumper = false){

            sr.setPower(0);
            sl.setPower(0);

        }
*/


    }
}