package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

/**
 * Created by 19jasonides_a on 12/01/16.
 */
public class AutoOpTest extends PushBotTelemetry {

    @Override
    public void loop() {
        try {
        telemetry.addData("1", getRuntime());
            Thread.sleep(5000);
            set_drive_power(0,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
