package org.firstinspires.ftc.teamcode.OpModes.Autonomi.BasketSide;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.BananaFruit;
import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;

@Autonomous(name ="Blue Side, Basket - Autonomous")
public class BlueSideBasket extends LinearOpMode {

    DriveTrain driveTrain;
    Grabber grabber;
    Misc misc;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap, DcMotor.ZeroPowerBehavior.BRAKE);
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

    /*  Grabber Commands:
        grabber.setHeightTo(telemetry, 500);
        grabber.toggleGrabberAuto();

        Drive Train Commands:
        driveTrain.moveForwardsBy(telemetry, 10);
        driveTrain.turnToHeading(gyro, telemetry, 90);

        Misc:
        sleep(1000);
        misc.toggleCarouselAuto();
    */

        grabber.toggleGrabberAuto();
        sleep(500);
        grabber.setHeightTo(telemetry, 250);

        driveTrain.moveForwardsBy(telemetry, 9);
        driveTrain.turnToHeading(gyro, telemetry, 35);
        grabber.setHeightTo(telemetry, 2000);
        driveTrain.moveForwardsBy(telemetry, 23);
        sleep(700);
        grabber.toggleGrabberAuto();
        sleep(350);

        driveTrain.moveForwardsBy(telemetry, -20);
        driveTrain.turnToHeading(gyro, telemetry, -90);
        driveTrain.moveForwardsBy(telemetry, 50);

        grabber.setHeightTo(telemetry, 0);

    }
}