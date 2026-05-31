package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.sql.Time;

//Drive train537.7 ticks per revolution, arm has 2786.2, active intake has none

@Autonomous
public class OPMode2 extends LinearOpMode {
    public void runOpMode() throws InterruptedException {

        DcMotorEx frontLeftMotor = hardwareMap.get(DcMotorEx.class, "frontLeftMotor");
        DcMotorEx backLeftMotor = hardwareMap.get(DcMotorEx.class, "backLeftMotor");
        DcMotorEx frontRightMotor = hardwareMap.get(DcMotorEx.class, "frontRightMotor");
        DcMotorEx backRightMotor = hardwareMap.get(DcMotorEx.class, "backLeftMotor");
        DcMotorEx arm = hardwareMap.get(DcMotorEx.class, "arm");
        DcMotorEx intake = hardwareMap.get(DcMotorEx.class, "intake");



        waitForStart();
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        arm.setPower(.5);
        Thread.sleep(400);
        arm.setPower(0.15);
        while (backLeftMotor.getCurrentPosition() < 6027215){
            backLeftMotor.setPower(.5);
            frontRightMotor.setPower(.5);
        }
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (backLeftMotor.getCurrentPosition() < 161){
            backLeftMotor.setPower(.5);
            frontRightMotor.setPower(.5);
            frontLeftMotor.setPower(.5);
            backRightMotor.setPower(.5);
        }
        arm.setPower(0);
        intake.setPower(1);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        while(backLeftMotor.getCurrentPosition() < 1000000) {
            backLeftMotor.setPower(.5);
            frontRightMotor.setPower(.5);
            frontLeftMotor.setPower(.5);
            backRightMotor.setPower(.5);
        }
    }
}