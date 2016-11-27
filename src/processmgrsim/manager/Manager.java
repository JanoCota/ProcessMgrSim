package processmgrsim.manager;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author janoc
 */
public class Manager {

    public final int SIZE;
    public final int MAXADDR;
    public final long STARTTIME;
    private ProcessLogger log;
    private int availSize;
    private LinkedList<Address> freeAddrTable;
    private LinkedList<Process> processQueue;
    private LinkedList<Process> processTable;

    public Manager(int memorySize) {
        this.SIZE = memorySize;
        this.MAXADDR = memorySize - 1;
        this.STARTTIME = System.currentTimeMillis();
        this.availSize = memorySize;
        this.log = new ProcessLogger();
        this.processQueue = new LinkedList<>();
        this.processTable = new LinkedList<>();
        this.freeAddrTable = new LinkedList<>();
        this.freeAddrTable.add(new Address(0, this.MAXADDR));
    }

    public int getProcessCount() {
        return processTable.size();
    }

    public int getQueueSize() {
        return processQueue.size();
    }

    public int getAvailSize() {
        return availSize;
    }

    public LinkedList<Process> getRunningProcesses() {
        return processTable;
    }

    public ProcessLogger getProcessLogger() {
        return log;
    }

    public int insert(Process p) {
        p.setTimeArrival(currentRunTime());
        log.insert(p);
        if (fits(p) && processQueue.isEmpty()) {
            load(p);
            return 0;
        } else {
            processQueue.add(p);
            return 1;
        }

    }

    public void kill(int PID) throws NoSuchElementException {
        Process p = find(PID);
        unload(p);
        loadFromQueue();
    }

    public void killAllRunning() {
        while (!processTable.isEmpty()) {
            Process p = processTable.peekFirst();
            unload(p);
            consolidateAddrTable();
        }
        loadFromQueue();
    }

    private void load(Process p) {
        int sizeRemainder = p.getSize();
        while (sizeRemainder > 0) {
            Address current = freeAddrTable.peekFirst();
            if (sizeRemainder > current.getTotalBytes()) {
                p.getAddr().add(current);
                sizeRemainder -= current.getTotalBytes();
                freeAddrTable.removeFirst();
            } else if (sizeRemainder == current.getTotalBytes()) {
                p.getAddr().add(current);
                freeAddrTable.removeFirst();
                sizeRemainder = 0;
            } else {
                p.getAddr().add(new Address(current.firstByte, current.firstByte + sizeRemainder - 1));
                current.firstByte += sizeRemainder;
                sizeRemainder = 0;
            }
        }
        processTable.add(p);
        p.setTimeLoaded(currentRunTime());
        this.availSize -= p.getSize();
    }

    protected void unload(Process p) {
        p.getAddr().forEach(a->
                freeAddrTable.add(a)
        );
        p.clrAddr();
        freeAddrTable.sort(null);
        consolidateAddrTable();
        processTable.remove(p);
        availSize += p.getSize();
        p.setTimeUnloaded(currentRunTime());
    }

    protected void loadFromQueue() {
        while (!processQueue.isEmpty() && fits(processQueue.peekFirst())) {
            load(processQueue.remove());
        }
    }

    private boolean fits(Process p) {
        return p.getSize() <= availSize;
    }

    private Process find(int PID) throws NoSuchElementException {
        return processTable.stream()
                .filter(i -> i.getPID() == PID)
                .findFirst()
                .get();
    }

    private long currentRunTime() {
        return System.currentTimeMillis() - STARTTIME;
    }

    private void consolidateAddrTable() {
        for (int i = 0; i < freeAddrTable.size() - 1; i++) {
            if (freeAddrTable.get(i).lastByte == freeAddrTable.get(i + 1).firstByte - 1) {
                freeAddrTable.get(i).lastByte = freeAddrTable.get(i + 1).lastByte;
                freeAddrTable.remove(i + 1);
                i--;
            }
        }
    }

}
