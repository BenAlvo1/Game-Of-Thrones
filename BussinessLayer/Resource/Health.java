package BussinessLayer.Resource;

public class Health {

    private Integer HealthPool; // maximum life
    public Integer HealthAmount; // current life

    public Health(Integer healthAmount){
        //constructor
        this.HealthAmount=healthAmount;
        this.HealthPool=healthAmount;
    }

    public void setHealthAmount(Integer healthAmount) {
        this.HealthAmount = healthAmount;
    }

    public void setHealthPool(Integer healthPool) {
        HealthPool = healthPool;
    }

    public Integer getHealthAmount() {
        return HealthAmount;
    }

    public Integer getHealthPool() {
        return HealthPool;
    }
}
