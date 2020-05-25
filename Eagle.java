public class Eagle extends Bird implements Fly  {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying &&  this.altitude ==0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    @Override
    public int ascend(int meters) {
        if (this.isFlying()) {
            this.altitude = Math.min(this.altitude + meters, 4800);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.getAltitude());
        }
        return meters;
    }

    @Override
    public int descend(int meters) {
        if (this.isFlying()) {
            
            this.altitude = Math.max(this.altitude - meters, 1);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.getAltitude());
        }
        return meters;
    }

    @Override
    public void glide() {
        if (this.isFlying()) {
            System.out.printf("It glides into the air.%n");
        }
    }

    @Override
    public void land() {
        if (this.isFlying() && this.getAltitude() < 10) {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't lands.%n", this.getName());
        }
    }
}
