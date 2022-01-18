package metier;

import java.util.Collections;
import java.util.Comparator;
import java.lang.Integer;


public class OrdrePriorityComparator implements Comparator<OrdreTravail> {
        @Override
        public int compare(OrdreTravail ot1, OrdreTravail ot2) {

            if (ot1.getPriorite() > ot2.getPriorite()) {
                return 1;
            } else if (ot1.getPriorite() < ot2.getPriorite()) {
                return -1;
            } else {
                return 0;
            }
        }
    }



