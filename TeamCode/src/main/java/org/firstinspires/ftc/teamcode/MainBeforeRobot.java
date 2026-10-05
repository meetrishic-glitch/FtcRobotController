package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MainBeforeRobot extends OpMode {
    @Override
    public void init() {

        telemetry.addLine("ready to run");
        telemetry.update();
    }

    @Override
    public void loop() {

    }
}
