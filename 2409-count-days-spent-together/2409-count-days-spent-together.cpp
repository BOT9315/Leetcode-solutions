class Solution {
public:
    int countDaysTogether(string arriveAlice, string leaveAlice,
                          string arriveBob, string leaveBob) {

        string start = max(arriveAlice, arriveBob);
        string end = min(leaveAlice, leaveBob);

        if (start > end) {
            return 0;
        }

        int days = 0;

        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 1 || i == 3 || i == 4) {
                continue;
            }
        }

        int startMonth = stoi(start.substr(0, 2));
        int startDay = stoi(start.substr(3, 2));

        int endMonth = stoi(end.substr(0, 2));
        int endDay = stoi(end.substr(3, 2));

        int monthDays[] = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};

        int startTotal = startDay;
        for (int i = 0; i < startMonth - 1; i++) {
            startTotal += monthDays[i];
        }

        int endTotal = endDay;
        for (int i = 0; i < endMonth - 1; i++) {
            endTotal += monthDays[i];
        }

        return endTotal - startTotal + 1;
    }
};