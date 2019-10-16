package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Testing_drive_train.DriveTrain;

@Disabled
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

    public void driving(){
        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;

        DriveTrain Wheels = new DriveTrain();
        Wheels.init(hardwareMap);

        if (Math.abs(gamepad1.left_stick_x) > .1 || Math.abs(gamepad1.left_stick_y) > .1 || Math.abs(gamepad1.right_stick_x) > .1) {
            Wheels.DrivePower(x, y, r);
        }else {
            Wheels.DrivePower(0,0,0);
        }
    }
}
