package processmgrsim.manager;

import java.util.LinkedList;

/**
 *
 * @author janoc
 */
public class Process {

    private int PID;
    private int size;
    private LinkedList<Address> addr;

    private long timeArrival;
    private long timeLoaded;
    private long timeUnloaded;

    public Process(int PID, int size) {
        this.PID = PID;
        this.size = size;
        this.addr = new LinkedList<>();
    }

    public int getPID() {
        return PID;
    }
    public int getSize() {
        return size;
    }

    public LinkedList<Address> getAddr() {
        return addr;
    }
    public void clrAddr() {
        this.addr.clear();
    }

    public long getTimeArrival() {
        return timeArrival;
    }
    public void setTimeArrival(long timeArrival) {
        this.timeArrival = timeArrival;
    }
    public long getTimeLoaded() {
        return timeLoaded;
    }
    public void setTimeLoaded(long timeLoaded) {
        this.timeLoaded = timeLoaded;
    }
    public long getTimeUnloaded() {
        return timeUnloaded;
    }
    public void setTimeUnloaded(long timeUnloaded) {
        this.timeUnloaded = timeUnloaded;
    }
    
    @Override
    public String toString(){
        return String.format("[%d] %d bytes", this.PID, this.size);
    }
}
