package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class DriveTrain{
    //Initializing the dc motor objects:
    //Gradle Evil

    DcMotor flMotor0;
    DcMotor frMotor0;
    DcMotor blMotor0;
    DcMotor brMotor0;
    DcMotor flMotor1;
    DcMotor frMotor1;
    DcMotor blMotor1;
    DcMotor brMotor1;
    Toggle toggleSpeed;
    int targetHeading;
    //Sets the acceptable margin of error for the heading (in degrees)
    final double HEADING_ACCURACY = 2;

    public static DriveTrain initDriveTrain(HardwareMap hardwareMap, DcMotor.ZeroPowerBehavior brakeAction) {
        //Hardware mapping the motors:
        DriveTrain driveTrain = new DriveTrain();

        driveTrain.flMotor0 = hardwareMap.dcMotor.get("frontLeftMotor0");
        driveTrain.frMotor0 = hardwareMap.dcMotor.get("frontRightMotor0");
        driveTrain.blMotor0 = hardwareMap.dcMotor.get("backLeftMotor0");
        driveTrain.brMotor0 = hardwareMap.dcMotor.get("backRightMotor0");
        driveTrain.flMotor1 = hardwareMap.dcMotor.get("frontLeftMotor1");
        driveTrain.frMotor1 = hardwareMap.dcMotor.get("frontRightMotor1");
        driveTrain.blMotor1 = hardwareMap.dcMotor.get("backLeftMotor1");
        driveTrain.brMotor1 = hardwareMap.dcMotor.get("backRightMotor1");

        driveTrain.flMotor0.setZeroPowerBehavior(brakeAction);
        driveTrain.frMotor0.setZeroPowerBehavior(brakeAction);
        driveTrain.blMotor0.setZeroPowerBehavior(brakeAction);
        driveTrain.brMotor0.setZeroPowerBehavior(brakeAction);
        driveTrain.flMotor1.setZeroPowerBehavior(brakeAction);
        driveTrain.frMotor1.setZeroPowerBehavior(brakeAction);
        driveTrain.blMotor1.setZeroPowerBehavior(brakeAction);
        driveTrain.brMotor1.setZeroPowerBehavior(brakeAction);

        driveTrain.toggleSpeed = new Toggle();

        return driveTrain;
    }

    public void manualDrive(Gamepad gamepad1){
        if(!toggleSpeed.isToggled()) {
            flMotor0.setPower(gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            frMotor0.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
            blMotor0.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            brMotor0.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
            flMotor1.setPower(gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            frMotor1.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
            blMotor1.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            brMotor1.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
        }else{
            flMotor0.setPower((gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            frMotor0.setPower((gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            blMotor0.setPower((-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            brMotor0.setPower((-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            flMotor1.setPower((gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            frMotor1.setPower((gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            blMotor1.setPower((-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            brMotor1.setPower((-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
        }
    }

    public void checkToggleSpeed(Gamepad gamepad1){
        if(gamepad1.left_bumper){
            toggleSpeed.toggle();
        }
    }

    public static void logTelemetry(Telemetry telemetry, DriveTrain driveTrain) {
        //telemetry.addData("Heading", driveTrain.getHeading() + " degrees");
        //1120 ticks in a rotation
        telemetry.addData("FL Power", driveTrain.flMotor0.getPower());
        telemetry.addData("FR Power", driveTrain.frMotor0.getPower());
        telemetry.addData("BL Power", driveTrain.blMotor0.getPower());
        telemetry.addData("BR Power", driveTrain.brMotor0.getPower());
    }

    private void goForwardsTo(double inches) throws InterruptedException{
        Thread.sleep(1);
        resetEncoders();
        Thread.sleep(1);
        setBasePower(0.8);
        Thread.sleep(1);

        int targetPosition;
        double rotations;

        rotations = inches / (4*Math.PI);
        targetPosition = (int)(rotations * 1120);

        flMotor0.setTargetPosition(targetPosition);
        frMotor0.setTargetPosition(-targetPosition);
        blMotor0.setTargetPosition(targetPosition);
        brMotor0.setTargetPosition(-targetPosition);
        flMotor1.setTargetPosition(targetPosition);
        frMotor1.setTargetPosition(-targetPosition);
        blMotor1.setTargetPosition(targetPosition);
        brMotor1.setTargetPosition(-targetPosition);

        Thread.sleep(1);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(1);
    }

    public void setRunMode(DcMotor.RunMode runMode){
        flMotor0.setMode(runMode);
        frMotor0.setMode(runMode);
        blMotor0.setMode(runMode);
        brMotor0.setMode(runMode);
        flMotor1.setMode(runMode);
        frMotor1.setMode(runMode);
        blMotor1.setMode(runMode);
        brMotor1.setMode(runMode);
    }

    public void setBasePower(double power){
        flMotor0.setPower(power);
        frMotor0.setPower(power);
        blMotor0.setPower(power);
        brMotor0.setPower(power);
        flMotor1.setPower(power);
        frMotor1.setPower(power);
        blMotor1.setPower(power);
        brMotor1.setPower(power);
    }

    public void resetEncoders(){
        setBasePower(0);
        setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setBasePower(0);
    }

    public void moveForwardsBy(Telemetry telemetry, double inches) throws InterruptedException{
        //Going Forwards
        goForwardsTo(inches);
        Thread.sleep(10);
        while(isBusy()){
            telemetry.update();
            Thread.sleep(1);
        }
        Thread.sleep(10);
    }

    public boolean isBusy(){
        return (flMotor0.isBusy() && blMotor0.isBusy() && frMotor0.isBusy() && brMotor0.isBusy() && flMotor1.isBusy() && blMotor1.isBusy() && frMotor1.isBusy() && brMotor1.isBusy());
    }

    public boolean isCorrectHeading(int currentHeading){
        return (targetHeading < currentHeading + HEADING_ACCURACY && targetHeading > currentHeading - HEADING_ACCURACY);
    }

    private boolean isWithinDangerZone(int heading){
        return (heading > 145 || heading < -145);
    }

    private void turnRobotToHeading(int currentHeading, int targetHeading){
        if(isWithinDangerZone(targetHeading) && targetHeading < 0){
            if(isWithinDangerZone(currentHeading) && currentHeading > 0){
                    currentHeading -= 360;
            }
        }else if(isWithinDangerZone(targetHeading) && targetHeading > 0){
            if(isWithinDangerZone(currentHeading) && currentHeading < 0){
                currentHeading += 360;
            }
        }

        double modifier, startingPower, difference;
        difference = Math.abs(targetHeading - currentHeading);
        modifier = ((Math.sqrt((difference)))/2);
        startingPower = 0.1;

        if(targetHeading < currentHeading - HEADING_ACCURACY){
            flMotor0.setPower(startingPower * modifier);
            frMotor0.setPower(startingPower * modifier);
            blMotor0.setPower(startingPower * modifier);
            brMotor0.setPower(startingPower * modifier);
            flMotor1.setPower(startingPower * modifier);
            frMotor1.setPower(startingPower * modifier);
            blMotor1.setPower(startingPower * modifier);
            brMotor1.setPower(startingPower * modifier);
        }else if(targetHeading > currentHeading + HEADING_ACCURACY){
            flMotor0.setPower(-startingPower * modifier);
            frMotor0.setPower(-startingPower * modifier);
            blMotor0.setPower(-startingPower * modifier);
            brMotor0.setPower(-startingPower * modifier);
            flMotor1.setPower(-startingPower * modifier);
            frMotor1.setPower(-startingPower * modifier);
            blMotor1.setPower(-startingPower * modifier);
            brMotor1.setPower(-startingPower * modifier);
        }else{
            flMotor0.setPower(0);
            frMotor0.setPower(0);
            blMotor0.setPower(0);
            brMotor0.setPower(0);
            flMotor1.setPower(0);
            frMotor1.setPower(0);
            blMotor1.setPower(0);
            brMotor1.setPower(0);
        }
    }



    public void turnToHeading(BananaFruit gyro, Telemetry telemetry, int inputTargetHeading) throws InterruptedException{
        //Turning
        targetHeading = -inputTargetHeading;
        setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int i = 0;
        while(!isCorrectHeading(gyro.getHeading()) && i < 3000){
            telemetry.update();
            turnRobotToHeading(gyro.getHeading(), targetHeading);
            Thread.sleep(1);
            i++;
        }

        Thread.sleep(10);
        flMotor0.setPower(0);
        frMotor0.setPower(0);
        blMotor0.setPower(0);
        brMotor0.setPower(0);
        flMotor1.setPower(0);
        frMotor1.setPower(0);
        blMotor1.setPower(0);
        brMotor1.setPower(0);
        Thread.sleep(10);

    }


}


