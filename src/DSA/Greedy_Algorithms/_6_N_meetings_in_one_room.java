package DSA.Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class meeting {
    int start;
    int end;
    int position;

    public meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

//The meetings are sorted by their ending times in ascending order,
//and if two meetings have the same ending time,
//they are sorted by their positions in ascending order.
class meetingComparator implements Comparator<meeting> {
    @Override
    public int compare(meeting o1, meeting o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        } else if (o1.position < o2.position) {
            return -1;
        }
        return 1;
    }
}

public class _6_N_meetings_in_one_room {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        ArrayList<meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meetings, new meetingComparator());

        ArrayList<Integer> answer = new ArrayList<>();
        //ith position meetings that can happen.
        answer.add(meetings.get(0).position);

        //Get the last-ended meeting.
        int limit = meetings.get(0).end;

        for (int i = 1; i < start.length; i++) {
            //Send the meeting which starts after the last meeting.
            if (meetings.get(i).start > limit) {
                limit = meetings.get(i).end;
                //Store the position of the meeting.
                answer.add(meetings.get(i).position);
            }
        }

        return answer.size();
    }
}
