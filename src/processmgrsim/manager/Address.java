package processmgrsim.manager;

/**
 *
 * @author janoc
 */
public class Address implements Comparable<Address> {

    public int firstByte;
    public int lastByte;

    public Address(int firstByte, int lastByte) {
        this.firstByte = firstByte;
        this.lastByte = lastByte;
    }

    public int getTotalBytes() {
        return lastByte - firstByte + 1;
    }

    @Override
    public int compareTo(Address other) {
        if (this.lastByte < other.firstByte) {
            return -1;
        } else if (other.lastByte < this.firstByte) {
            return 1;
        } else {
            return 0;
        }
    }
}
