package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;

@TeleOp(name ="Dual Driver TeleOp - CM", group = "TeleOp")
public class DualDriverTeleOp extends OpMode {
    //Initializing the main objects:
    Grabber grabber;
    DriveTrain driveTrain;
    Misc misc;

    @Override
    public void init(){
        //Hardware mapping the servos:
        grabber = Grabber.initGrabber(hardwareMap);
        driveTrain = DriveTrain.initDriveTrain(hardwareMap, DcMotor.ZeroPowerBehavior.FLOAT);
        misc = Misc.initMiscellaneous(hardwareMap);

        driveTrain.resetEncoders();
        driveTrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override public void loop(){
        //Drive Train manual control system
        driveTrain.manualDrive(gamepad1);
        driveTrain.checkToggleSpeed(gamepad1);
        DriveTrain.logTelemetry(telemetry, driveTrain);

        //Grabber System (Servos)
        grabber.ManualToggleGrabber(gamepad1);
        telemetry.addData("Left Servo Position", grabber.leftServoPosition());
        telemetry.addData("Right Servo Position", grabber.rightServoPosition());

        //Spool controls
        grabber.ManualSpoolMotor(gamepad2);
        telemetry.addData("Spool Motor Position", grabber.spoolMotor.getCurrentPosition());

        //Misc controls
        misc.toggleCarouselPowerManual(gamepad2);
        misc.toggleCarouselDirectionManual(gamepad2);
        misc.runCarouselServo();
    }

}