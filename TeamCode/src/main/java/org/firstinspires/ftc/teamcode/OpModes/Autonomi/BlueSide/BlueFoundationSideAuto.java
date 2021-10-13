package org.firstinspires.ftc.team9202hme.OpModes.Autonomi.BlueSide;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team9202hme.Objects.BananaFruit;
import org.firstinspires.ftc.team9202hme.Objects.DriveTrain;
import org.firstinspires.ftc.team9202hme.Objects.Grabber;
import org.firstinspires.ftc.team9202hme.Objects.Misc;

@Autonomous(name ="BlueFoundationSide - Autonomous", group = "Blue Side")
public class BlueFoundationSideAuto extends LinearOpMode {

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

        //THIS IS THE AUTONOMOUS CODE FOR BLUE FOUNDATION SIDE

        //Setting servos and motors to the correct position
        grabber.leftServo.setPosition(0);
        grabber.rightServo.setPosition(1);
        misc.foundationGrabber.setPosition(180);
        grabber.setHeightTo(telemetry, 0);

        //Adjusting to line up with the foundation
        driveTrain.moveForwardsBy(telemetry, 5);
        driveTrain.turnToHeading(gyro, telemetry, 90);
        driveTrain.moveForwardsBy(telemetry, 21);
        driveTrain.turnToHeading(gyro, telemetry, 0);

        //Rising the drawer slides
        grabber.setHeightTo(telemetry, 2500);

        //Going towards the foundation
        driveTrain.moveForwardsBy(telemetry, 24);

        //Lowering the drawer slides
        grabber.setHeightTo(telemetry, 0);

        //Moving back a tile or so
        driveTrain.moveForwardsBy(telemetry, -18);

        //Turning towards the build site
        driveTrain.turnToHeading(gyro, telemetry, 90);

        //Raising the drawer slides and detaching
        grabber.setHeightTo(telemetry, 2500);
        driveTrain.moveForwardsBy(telemetry, -24);

        //Lowering the drawer slides again
        grabber.setHeightTo(telemetry, 0);

        //Parking under the skybridge
        driveTrain.moveForwardsBy(telemetry, -10);

        //STILL REQUIRES TESTING
    }
}