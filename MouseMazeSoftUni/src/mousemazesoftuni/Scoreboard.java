package mousemazesoftuni;

import java.io.Serializable;
import java.util.ArrayList;

public class Scoreboard implements Serializable {

    public static interface Listener {

        public void onSubmitEntry();
    }

    private static class Record implements Serializable {

        private long time;
        private String name;

        private Record(final long time, final String name) {
            this.time = time;
            this.name = name;
        }
    }

    public static final int CAPACITY = 10;

    private transient Listener listener = null;

    private long entryTime = Long.MAX_VALUE;
    private String entryName = null;
    private ArrayList<Record> records = null;

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public boolean requestEntry(final long time) {
        if (records != null) {
            int size = records.size();
            if (size == CAPACITY && time >= records.get(size - 1).time) {
                return false;
            }
        }
        entryTime = time;
        return true;
    }

    //0 binary search
    private int findEntryIndex(int first, int last, long entryTime) {
        while (first != last) {
            final int mid = last + first >> 1;
            if (records.get(mid).time <= entryTime) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        if (records.get(first).time <= entryTime) {
            first++;
        }
        return first;
    }

    public boolean submitEntry(String entryName) {
        long entryTime = this.entryTime;
        this.entryTime = Long.MAX_VALUE;
        this.entryName = entryName;
        int size;
        if (records != null) {
            size = records.size();
        } else {
            size = 0;
        }
        if (size == 0) {
            records = new ArrayList<Record>(CAPACITY);
            Record record = new Record(entryTime, entryName);
            records.add(record);
            if (listener != null) {
                listener.onSubmitEntry();
            }
            return true;
        }
        int last = size - 1;
        int index = findEntryIndex(0, last, entryTime);
        if (index >= CAPACITY) {
            return false;
        }
        Record record;
        if (size < CAPACITY) {
            record = new Record(entryTime, entryName);
            records.add(index, record);
            if (listener != null) {
                listener.onSubmitEntry();
            }
            return true;
        }
        record = records.get(last);
        record.time = entryTime;
        record.name = entryName;
        if (index < last) {
            records.remove(last);
            records.add(index, record);
        }
        if (listener != null) {
            listener.onSubmitEntry();
        }
        return true;
    }

    public void clearEntry() {
        entryTime = Long.MAX_VALUE;
    }

    public void clear() {
        if (records != null) {
            records.clear();
        }
    }

    public String getEntryName() {
        return entryName;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String toTimeString(long time) {
        StringBuilder sb = new StringBuilder();
        long hours = time / 3600;
        long minutes = time % 3600 / 60;
        long seconds = time % 60;
        if (hours < 10) {
            sb.append('0');
        }
        sb.append(hours);
        sb.append(" : ");
        if (minutes < 10) {
            sb.append('0');
        }
        sb.append(minutes);
        sb.append(" : ");
        if (seconds < 10) {
            sb.append('0');
        }
        sb.append(seconds);
        return sb.toString();
    }

    @Override
    public String toString() {
        int size;
        if (records != null) {
            size = records.size();
        } else {
            size = 0;
        }
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Record record = records.get(i);
            sb.append(i + 1);
            sb.append('\t');
            String timeString = toTimeString(record.time);
            sb.append(timeString);
            sb.append('\t');
            sb.append(record.name);
            sb.append('\n');
        }
        return sb.toString();
    }
}
