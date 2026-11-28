package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class testCode1 {
    private DcMotor leftBack;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor rightFront;
    private DcMotorEx flywheel;
    private DcMotorEx mainIntake;
    public void init( HardwareMap hwMap) {


        rightBack = hwMap.get(DcMotor.class, "rightBack");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftBack = hwMap.get(DcMotor.class, "leftBack");
        leftFront = hwMap.get(DcMotor.class, "leftFront");
        flywheel = hwMap.get(DcMotorEx.class, "flywheel");
        mainIntake = hwMap.get(DcMotorEx.class, "mainIntake");
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mainIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setMoterSpeed(String moterName, double speed) {
        switch (moterName) {
            case "rightBack":
                rightBack.setPower(speed);
                break;
            case "rightFront":
                rightFront.setPower(speed);
                break;
            case "leftBack":
                leftBack.setPower(speed);
                break;
            case "leftFront":
                leftFront.setPower(speed);
                break;
            case "flywheel":
                flywheel.setVelocity(speed);
                break;
            case "mainIntake":
                mainIntake.setVelocity(speed);
                break;
            case "all drive":
                rightBack.setPower(speed);
                rightFront.setPower(speed);
                leftBack.setPower(speed);
                leftFront.setPower(speed);
                break;
        }
    }

    public double getFlywheelVelocity() {
        return flywheel.getVelocity();
    }

    public double getIntakeVelocity() {
        return mainIntake.getVelocity();
    }
}