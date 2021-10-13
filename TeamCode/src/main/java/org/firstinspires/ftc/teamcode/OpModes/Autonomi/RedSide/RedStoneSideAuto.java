package org.firstinspires.ftc.team9202hme.OpModes.Autonomi.RedSide;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team9202hme.Objects.BananaFruit;
import org.firstinspires.ftc.team9202hme.Objects.DriveTrain;
import org.firstinspires.ftc.team9202hme.Objects.Grabber;
import org.firstinspires.ftc.team9202hme.Objects.Misc;

@Autonomous(name ="RedStoneSide - Autonomous", group = "Red Side")
public class RedStoneSideAuto extends LinearOpMode {

    DriveTrain driveTrain;
    Grabber grabber;
    Misc misc;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap);
        grabber = Grabber.initGrabber(hardwareMap);
        misc = Misc.initMiscellaneous(hardwareMap);

        telemetry.addData("IsBusy", driveTrain.isBusy());
        driveTrain.logTelemetry(telemetry, driveTrain);
        telemetry.update();
        driveTrain.resetEncoders();
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();


        //ONLY MODIFY STUFF AFTER THIS


        //Sets the height to a safe height
        grabber.setHeightTo(telemetry, 500);

        //The encoders on everything except the spool motor reset each time you run it


        //THIS IS THE AUTONOMOUS CODE FOR BLUE STONE SIDE

        //Setting servos and motors to the correct position
        grabber.leftServo.setPosition(0);
        grabber.rightServo.setPosition(1);
        misc.foundationGrabber.setPosition(180);
        grabber.setHeightTo(telemetry, 0);

        //Going to pick up skystone
        driveTrain.moveForwardsBy(telemetry, 26);

        //Picking up skystone
        grabber.leftServo.setPosition(0.95);
        grabber.rightServo.setPosition(0.05);
        sleep(1000);

        //Moving back one tile
        driveTrain.moveForwardsBy(telemetry, -5);

        //Turning towards the building side
        driveTrain.turnToHeading(gyro, telemetry, -90);

        //Moving to the build side
        driveTrain.moveForwardsBy(telemetry, 40);

        //Letting go of skystone
        grabber.leftServo.setPosition(0);
        grabber.rightServo.setPosition(1);
        sleep(1000);

        //Parking
        driveTrain.moveForwardsBy(telemetry, -16);

        //STILL REQUIRES TESTING
    }
}