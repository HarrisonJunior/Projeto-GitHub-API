package models;
/**
 * @author Harrison J. S. Amorim
 * @version 1.0
 */
public class Contributor implements Comparable<Contributor> {
    private String name;
    private int contributions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    /**
     *
     * @param otherContributor
     *
     */
    @Override
    public int compareTo(Contributor otherContributor) {
        if (this.contributions > otherContributor.getContributions()) {
            return -1;
        }
        if (this.contributions < otherContributor.getContributions()) {
            return 1;
        }
        return 0;
    }
}
