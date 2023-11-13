package Shared;

public class HalfAnimalPackage {
    private int  half_package_id;

    public HalfAnimalPackage()
    {
    }

    public HalfAnimalPackage(int half_package_id) {
        this.half_package_id = half_package_id;
    }

    public int getHalf_package_id() {
        return half_package_id;
    }

    public void setHalf_package_id(int half_package_id) {
        this.half_package_id = half_package_id;
    }

    public String toString()
    {
        return "Package type: Half Animal Package; Id: "+half_package_id;
    }
}
