package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class DriveTrain{
    //Initializing the dc motor objects:
    //Gradle Evil

    DcMotor flMotor;
    DcMotor frMotor;
    DcMotor blMotor;
    DcMotor brMotor;
    Toggle toggleSpeed;
    int targetHeading;
    //Sets the acceptable margin of error for the heading (in degrees)
    final double HEADING_ACCURACY = 2;

    public static DriveTrain initDriveTrain(HardwareMap hardwareMap, DcMotor.ZeroPowerBehavior brakeAction) {
        //Hardware mapping the motors:
        DriveTrain driveTrain = new DriveTrain();

        driveTrain.flMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        driveTrain.frMotor = hardwareMap.dcMotor.get("frontRightMotor");
        driveTrain.blMotor = hardwareMap.dcMotor.get("backLeftMotor");
        driveTrain.brMotor = hardwareMap.dcMotor.get("backRightMotor");

        driveTrain.flMotor.setZeroPowerBehavior(brakeAction);
        driveTrain.frMotor.setZeroPowerBehavior(brakeAction);
        driveTrain.blMotor.setZeroPowerBehavior(brakeAction);
        driveTrain.brMotor.setZeroPowerBehavior(brakeAction);

        driveTrain.toggleSpeed = new Toggle();

        return driveTrain;
    }

    public void manualDrive(Gamepad gamepad1){
        if(!toggleSpeed.isToggled()) {
            flMotor.setPower(gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            frMotor.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
            blMotor.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            brMotor.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
        }else{
            flMotor.setPower((gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            frMotor.setPower((gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            blMotor.setPower((-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            brMotor.setPower((-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
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
        telemetry.addData("FL Power", driveTrain.flMotor.getPower());
        telemetry.addData("FR Power", driveTrain.frMotor.getPower());
        telemetry.addData("BL Power", driveTrain.blMotor.getPower());
        telemetry.addData("BR Power", driveTrain.brMotor.getPower());
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

        flMotor.setTargetPosition(targetPosition);
        frMotor.setTargetPosition(-targetPosition);
        blMotor.setTargetPosition(targetPosition);
        brMotor.setTargetPosition(-targetPosition);

        Thread.sleep(1);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(1);
    }

    public void setRunMode(DcMotor.RunMode runMode){
        flMotor.setMode(runMode);
        frMotor.setMode(runMode);
        blMotor.setMode(runMode);
        brMotor.setMode(runMode);
    }

    public void setBasePower(double power){
        flMotor.setPower(power);
        frMotor.setPower(power);
        blMotor.setPower(power);
        brMotor.setPower(power);
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
        return (flMotor.isBusy() && blMotor.isBusy() && frMotor.isBusy() && brMotor.isBusy());
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
            flMotor.setPower(startingPower * modifier);
            frMotor.setPower(startingPower * modifier);
            blMotor.setPower(startingPower * modifier);
            brMotor.setPower(startingPower * modifier);
        }else if(targetHeading > currentHeading + HEADING_ACCURACY){
            flMotor.setPower(-startingPower * modifier);
            frMotor.setPower(-startingPower * modifier);
            blMotor.setPower(-startingPower * modifier);
            brMotor.setPower(-startingPower * modifier);
        }else{
            flMotor.setPower(0);
            frMotor.setPower(0);
            blMotor.setPower(0);
            brMotor.setPower(0);
        }
    }



    public void turnToHeading(BananaFruit gyro, Telemetry telemetry, int inputTargetHeading) throws InterruptedException{
        //Turning
        targetHeading = -inputTargetHeading;
        setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        while(!isCorrectHeading(gyro.getHeading())){
            telemetry.update();
            turnRobotToHeading(gyro.getHeading(), targetHeading);
            Thread.sleep(1);
        }

        Thread.sleep(10);
        flMotor.setPower(0);
        frMotor.setPower(0);
        blMotor.setPower(0);
        brMotor.setPower(0);
        Thread.sleep(10);

    }


}


