package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by 19jasonides_a on 06/02/16.
 */
public class AutoOpTest2 extends PushBotTelemetry {

    @Override
    public void loop() {
        try {
            telemetry.addData("1", getRuntime());
            Thread.sleep(5000);
            set_drive_power(1,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
