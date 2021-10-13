package org.firstinspires.ftc.teamcode.Tool;


public class Toggle {
    private double cooldownTime;
    private boolean toggled;
    private double time;

    //e
    public Toggle(double cooldownTime) {
        this.cooldownTime = cooldownTime;
        toggled = false;
        time = System.nanoTime();
    }

    public Toggle() {
        this(0.25);
    }

    public void toggle() {
        if((System.nanoTime() - time) / 1e9 >= cooldownTime) {
            toggled = !toggled;
            time = System.nanoTime();
        }
    }

    public boolean isToggled() {
        return toggled;
    }
}
