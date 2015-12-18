package com.qualcomm.ftcrobotcontroller.opmodes;

public class TestOp2 extends PushBotTelemetry {

    int speed;

    public TestOp2() {


    } // PushBotManual1

    @Override public void loop ()

    {
        double l_gp1_left_stick_y = gamepad1.left_stick_y;
        double l_left_drive_power
                = scale_motor_power ((float) l_gp1_left_stick_y);

        double l_gp1_right_stick_y = gamepad1.right_stick_y;
        double l_right_drive_power
                = scale_motor_power ((float) l_gp1_right_stick_y);

        if (gamepad1.dpad_up) {

            speed++;

        } else if (gamepad1.dpad_down) {

            speed--;
        }

        else {


        }

        set_drive_power (l_left_drive_power * speed, l_right_drive_power * speed);

        float l_left_arm_power
                = (float)scale_motor_power (gamepad1.right_trigger)
                - (float)scale_motor_power (gamepad1.left_trigger);
        m_left_arm_power (l_left_arm_power);

        if (gamepad1.dpad_right)
        {
            m_hand_position (a_hand_position () + 0.05);
        }
        else if (gamepad1.dpad_left)
        {
            m_hand_position (a_hand_position () - 0.05);
        }

        update_telemetry (); // Update common telemetry
        update_gamepad_telemetry ();
        telemetry.addData
                ( "12"
                        , "Left Arm: " + l_left_arm_power
                );

    } // loop

} // PushBotManual1
