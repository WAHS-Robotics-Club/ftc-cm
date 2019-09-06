package org.firstinspires.ftc.teamcode.last_year;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "Learning Stuff")
public class Learning_Stuff extends OpMode {
    DcMotor wheels;
    int r;
    @Override
    public void init() {

    }

    @Override
    public void loop() {



        while (gamepad1.left_bumper = true) {
        wheels.setPower(2);
        }



        this.Fly(3);

    }


    private void Fly(double vwoop){
        wheels.setPower(-3 * vwoop);
    }
}
