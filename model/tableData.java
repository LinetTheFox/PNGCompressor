package PNGCompressor.model;

public class tableData {
    private String name;
    private long origSize;
    private long pngSize;
    private double pngEffect;
    private long pngTime;
    private long gifSize;
    private double gifEffect;
    private long gifTime;

    tableData() {
        this.name = "";
        this.origSize = 0;
        this.pngSize = 0;
        this.pngEffect = 0;
        this.pngTime = 0;
        this.gifSize = 0;
        this.gifEffect = 0;
        this.gifTime = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOrigSize() {
        return origSize;
    }

    public void setOrigSize(long origSize) {
        this.origSize = origSize;
    }

    public long getPngSize() {
        return pngSize;
    }

    public void setPngSize(long pngSize) {
        this.pngSize = pngSize;
    }

    public double getPngEffect() {
        return pngEffect;
    }

    public void setPngEffect(double pngEffect) {
        this.pngEffect = pngEffect;
    }

    public long getPngTime() {
        return pngTime;
    }

    public void setPngTime(long pngTime) {
        this.pngTime = pngTime;
    }

    public long getGifSize() {
        return gifSize;
    }

    public void setGifSize(long gifSize) {
        this.gifSize = gifSize;
    }

    public double getGifEffect() {
        return gifEffect;
    }

    public void setGifEffect(double gifEffect) {
        this.gifEffect = gifEffect;
    }

    public long getGifTime() {
        return this.gifTime;
    }

    public void setGifTime(long gifTime) {
        this.gifTime = gifTime;
    }
}
