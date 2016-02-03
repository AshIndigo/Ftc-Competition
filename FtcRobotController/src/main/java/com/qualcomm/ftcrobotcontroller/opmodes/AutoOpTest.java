package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

/**
 * Created by 19jasonides_a on 12/01/16.
 */
public class AutoOpTest extends PushBotTelemetry {

    //TouchSensor touchSensor;
    //ColorSensor colorSensor;

    //@Override
    //public void init() {
        //touchSensor = hardwareMap.touchSensor.get("touch");
       // colorSensor = hardwareMap.colorSensor.get("color");
    //}

    @Override
    public void loop() {
    /*
        TouchSensor touchSensor = hardwareMap.touchSensor.get("touch");
        ColorSensor colorSensor = hardwareMap.colorSensor.get("color");
        colorSensor.enableLed(true);
            telemetry.addData("1", "Touch Sensor: " + touchSensor.isPressed());
            telemetry.addData("2", "Color Sensor: Red: " + colorSensor.red());
            telemetry.addData("3", "Color Sensor: Green: " + colorSensor.green());
            telemetry.addData("4", "Color Sensor: Blue: " + colorSensor.blue());
            telemetry.addData("5", "Color Sensor: ARGB: " + colorSensor.argb());
            telemetry.addData("5", "Color Sensor: Alpha: " + colorSensor.alpha());
            */
            set_drive_power(1, 1);
            telemetry.addData("1", getRuntime());
        m_left_arm_power(1);
        m_hand_position(0);
        }
}
