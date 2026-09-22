import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Plan> planList = new ArrayList<>();
        for (int index = 0; index < plans.length; index++) {
            String subject = plans[index][0];
            String time = plans[index][1];
            int playTime = Integer.parseInt(plans[index][2]);

            planList.add(new Plan(subject, time, playTime));
        }
        planList.sort(Comparator.comparing(Plan::getStartTime));

        Queue<Plan> newTask = new LinkedList<>(planList);
        Stack<Plan> stopTask = new Stack<>();
        Plan currentTask = null;
        int currentTime = 0;

        String[] answer = new String[plans.length];
        int index = 0;

        while (!newTask.isEmpty() || currentTask != null) {
            if (currentTask == null) {
                currentTask = newTask.poll();
                currentTime = currentTask.getStartTime();
            }

            int finishTime = currentTime + currentTask.getRemainingTime();

            if (!newTask.isEmpty() && newTask.peek().getStartTime() < finishTime) {
                // 새 과제가 현재 과제보다 먼저 시작해야 함 -> 현재 과제 중단
                Plan next = newTask.poll();
                int elapsed = next.getStartTime() - currentTime;
                currentTask.reduceTime(elapsed);
                stopTask.push(currentTask);

                currentTask = next;
                currentTime = next.getStartTime();
            } else {
                // 현재 과제를 끝까지 진행 -> 완료 처리
                answer[index++] = currentTask.getSubject();
                currentTime = finishTime;

                if (!newTask.isEmpty() && newTask.peek().getStartTime() == currentTime) {
                    // 새 과제 시작 시각과 겹치면 새 과제 우선
                    currentTask = newTask.poll();
                    currentTime = currentTask.getStartTime();
                } else if (!stopTask.isEmpty()) {
                    // 멈춰둔 과제 중 가장 최근 것 재개
                    currentTask = stopTask.pop();
                } else if (!newTask.isEmpty()) {
                    // 재개할 과제 없고, 새 과제 시작 시각까지 공백 -> 시간 점프
                    currentTask = newTask.poll();
                    currentTime = currentTask.getStartTime();
                } else {
                    currentTask = null;
                }
            }
        }

        return answer;
    }
}

class Plan {
    String subject;
    int startTime;
    int playTime;
    int remainingTime;

    public Plan(String subject, String time, int playTime) {
        this.subject = subject;
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        this.startTime = hour * 60 + minute;
        this.playTime = playTime;
        this.remainingTime = playTime;
    }

    public void reduceTime(int elapsed) {
        this.remainingTime -= elapsed;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getRemainingTime() {
        return this.remainingTime;
    }
}
