package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MoterPractice extends OpMode{
    private static final double FLYWHEEL_TARGET_TICKS_PER_SECOND = 5000;
    private static final double INTAKE_TARGET_TICKS_PER_SECOND = 1000.0;
    testCode1 bench= new testCode1();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double side = gamepad1.left_stick_x;
        String sideDirection = null;
        boolean intake = gamepad1.a;
        boolean flywheel = gamepad1.b;
        double rightBackPower = forward + side - turn;
        double rightFrontPower = forward - side + turn;
        double leftBackPower = forward - side - turn;
        double leftFrontPower = forward + side + turn;

        double maxPower = Math.max(1.0, Math.max(
                Math.max(Math.abs(rightBackPower), Math.abs(rightFrontPower)),
                Math.max(Math.abs(leftBackPower), Math.abs(leftFrontPower))));
        if (Math.abs(forward) < 0.05) forward = 0;
        if (Math.abs(turn) < 0.05) turn = 0;
        if (Math.abs(side) < 0.05) side = 0;
        if (turn<0) sideDirection = "left";
        if (turn==0) sideDirection = null;
        if (turn>0) sideDirection = "right";
        bench.setMoterSpeed("flywheel", flywheel ? FLYWHEEL_TARGET_TICKS_PER_SECOND : 0);
        bench.setMoterSpeed("mainIntake", intake ? INTAKE_TARGET_TICKS_PER_SECOND : 0);

        bench.setMoterSpeed("rightBack", rightBackPower/maxPower);
        bench.setMoterSpeed("rightFront", rightFrontPower/maxPower);
        bench.setMoterSpeed("leftBack", leftBackPower/maxPower);
        bench.setMoterSpeed("leftFront", leftFrontPower/maxPower);
        telemetry.addData("forward speed", forward);
        telemetry.addData("side speed", side);
        telemetry.addData("turn speed", String.valueOf(side), sideDirection);
        telemetry.addData("intake", intake);
        telemetry.addData("fly wheel", flywheel);
        telemetry.addData("flywheel velocity (ticks/sec)", bench.getFlywheelVelocity());
        telemetry.addData("intake velocity (ticks/sec)", bench.getIntakeVelocity());
        telemetry.update();
    }
}
